package yhdj.example.com.wuziqi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class StartActivity extends AppCompatActivity {
    private Button mBtnMenVsCom;
    private Button mBtnMenVsMen;
    private Button mBtnEntryRooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initViews();
    }

    private void initViews() {
        mBtnMenVsCom = (Button) findViewById(R.id.btn_menVsCom);
        mBtnMenVsMen = (Button) findViewById(R.id.btn_menVsMen);
        mBtnEntryRooms = (Button) findViewById(R.id.btn_entryRooms);
        mBtnEntryRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, RoomsActivity.class);
                startActivity(intent);
            }
        });

        mBtnMenVsCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        mBtnMenVsMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = LayoutInflater.from(StartActivity.this).inflate(R.layout.create_room, null, false);
                new AlertDialog.Builder(StartActivity.this)
                        .setView(view)
                        .setPositiveButton("创建", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText edtUsername = (EditText) view.findViewById(R.id.username);
                                String username = edtUsername.getText().toString();
                                Toast.makeText(StartActivity.this, "edtUsername" + username, Toast.LENGTH_SHORT).show();

                                EditText edtRoomName = (EditText) view.findViewById(R.id.roomName);
                                String roomName = edtRoomName.getText().toString();
                                final Match match = new Match();
                                match.setBegin(false);
                                match.setUsername(username);
                                match.setRoomName(roomName);
                                match.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        if (e == null) {
                                            Toast.makeText(StartActivity.this, "创建成功！！！", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(StartActivity.this, MainActivity.class);
                                            intent.putExtra("objectId", match.getObjectId());
                                            intent.putExtra("isBegin",match.isBegin());
                                            startActivity(intent);
                                        } else {
                                            Log.e("aaaaaaaaaaaaaa", "done: " + e.toString());
                                        }
                                    }
                                });
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                        .show();
            }
        });
    }
}
