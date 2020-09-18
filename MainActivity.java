package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    ProgressDialog mydialog;
    LinearLayout login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.bu1);
        btn1.setOnClickListener(new mClick());
    }

    class mClick implements View.OnClickListener {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

        public void onClick(View v) {
           if (v == btn1) {
                login = (LinearLayout) getLayoutInflater().inflate(R.layout.custom, null);
                dialog.setTitle("用户登录").setMessage("请输入用户名和密码").setView(login);
                dialog.setPositiveButton("确定", new loginClick());
                dialog.setNegativeButton("退出", new exitClick());
                dialog.create();
                dialog.show();
            }
        }

        class loginClick implements DialogInterface.OnClickListener{
            EditText txt;
            public void onClick(DialogInterface dialog,int which){
                txt = (EditText)login.findViewById(R.id.user_password);
                if((txt.getText().toString()).equals("123"))
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"密码错误",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }

        class exitClick implements DialogInterface.OnClickListener{
            public void onClick(DialogInterface dialog,int which){
                MainActivity.this.finish();
            }
        }
    }
}