package com.example.jisuanqi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HuanActivity extends Activity {
    private Button btn_changdu;
    private Button btn_v;
    private Button btn_jinzhi;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huansuan);
        btn_changdu = (Button)this.findViewById(R.id.button_long);
        btn_changdu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HuanActivity.this, MainActivityChangdu.class);
                intent.putExtra("name", "xiazdong");
                startActivity(intent);
            }
        });
        btn_v = (Button)this.findViewById(R.id.button_v);
        btn_v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HuanActivity.this, MainActivityTiji.class);
                intent.putExtra("name", "xiazdong");
                startActivity(intent);
            }
        });
        btn_jinzhi = (Button)this.findViewById(R.id.button_jinzhi);
        btn_jinzhi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HuanActivity.this, MainActivityJinzhi.class);
                intent.putExtra("name", "xiazdong");
                startActivity(intent);
            }
        });
        }


}


