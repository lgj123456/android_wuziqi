package yhdj.example.com.wuziqi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobRealTimeData;
import cn.bmob.v3.listener.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    private WuziqiPanel mWuziqiPanel;
    private boolean isBegin;
    private String objectId;
    private boolean isChooseWhite;
    private Gson mGson = new Gson();
    private ArrayList<Point> mWhiteArray = new ArrayList<>();
    private ArrayList<Point> mBlackArray = new ArrayList<>();
    private List<ChangedDataBean.DataBean.MBlackArrayBean> blackArray = new ArrayList<>();
    private List<ChangedDataBean.DataBean.MWhiteArrayBean> whiteArray = new ArrayList<>();
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
        initViews();
        dataIsChange();
    }

    private void dataIsChange() {
        final BmobRealTimeData rtd = new BmobRealTimeData();
        rtd.start(new ValueEventListener() {
            @Override
            public void onDataChange(JSONObject data) {
                Log.d("bmob", "(" + data.optString("action") + ")" + "数据：" + data);
                Log.e("aaaaaaaa", "onDataChange: " + data.toString());
                ChangedDataBean changedDataBean = mGson.fromJson(data.toString(), ChangedDataBean.class);
                dealData(changedDataBean);

            }

            @Override
            public void onConnectCompleted(Exception ex) {
                Log.d("bmob", "连接成功:" + rtd.isConnected());
                rtd.subRowUpdate("Match", objectId);
            }
        });
    }

    private void dealData(ChangedDataBean changedDataBean) {
        blackArray = changedDataBean.getData().getMBlackArray();
        whiteArray = changedDataBean.getData().getMWhiteArray();

        for (int i = 0; i < blackArray.size(); i++) {
            Point point = new Point(blackArray.get(i).getX(), blackArray.get(i).getY());
            mBlackArray.add(point);
        }

        for (int i = 0; i < whiteArray.size(); i++) {
            Point point = new Point(whiteArray.get(i).getX(), whiteArray.get(i).getY());
            mWhiteArray.add(point);
        }

        mWuziqiPanel.refreshPieces(mWhiteArray, mBlackArray);
        isBegin = changedDataBean.getData().isIsBegin();
        if (isBegin) {
            mProgressDialog.dismiss();
        }
        mWuziqiPanel.checkWin(changedDataBean.getData().getState());
    }

    private void getData() {
        Intent intent = getIntent();
        if (null != intent) {
            objectId = intent.getStringExtra("objectId");
            isBegin = intent.getBooleanExtra("isBegin", false);
        }
        if (isBegin && mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    private void initViews() {
        mWuziqiPanel = (WuziqiPanel) findViewById(R.id.wuziqi);
        mWuziqiPanel.sendMatchData(objectId);
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setTitle("温馨提示");
        mProgressDialog.setMessage("等待对手中······");
        mProgressDialog.setCancelable(false);
       // mProgressDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_again, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_again) {
            mWuziqiPanel.start();
            return true;
        } else if (id == R.id.chooseWhite) {
            isChooseWhite = true;
            mWuziqiPanel.sendIsChooseWhite(isChooseWhite);
        } else {
            isChooseWhite = false;
            mWuziqiPanel.sendIsChooseWhite(isChooseWhite);
        }

        return super.onOptionsItemSelected(item);
    }
}
