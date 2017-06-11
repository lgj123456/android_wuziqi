package yhdj.example.com.wuziqi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class RoomsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Match> mMatches = new ArrayList<>();
    private MyRoomsAdapter mMyRoomsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        initViews();
        queryData();
    }

    private void queryData() {
        BmobQuery<Match> query = new BmobQuery<Match>();


        query.setLimit(50);
//执行查询方法
        query.findObjects(new FindListener<Match>() {
            @Override
            public void done(List<Match> object, BmobException e) {
                if (e == null) {
                    for (Match match : object) {
                        mMatches.add(match);
                    }
runOnUiThread(new Runnable() {
    @Override
    public void run() {
        mMyRoomsAdapter.changeData(mMatches);
    }
});
                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mMyRoomsAdapter = new MyRoomsAdapter(mMatches);
        mRecyclerView.setAdapter(mMyRoomsAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(RoomsActivity.this));
    }
}
