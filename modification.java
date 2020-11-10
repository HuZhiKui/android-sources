package com.example.connectperson;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class modification extends Activity {


    private EditText e222;
    private Button update;
    public static List<String> lll=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modification);
        e222= (EditText) findViewById(R.id.et_phoneee);
        update =(Button)findViewById(R.id.btn_modificatioin);
        e222.setText(Fangwen.ll.toString());

        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lll.add(e222.getText().toString());
                Toast.makeText(getApplicationContext(),"修改完成",Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(modification.this, Fangwen.class);
                intent.putExtra("name", "xiazdong");
                startActivity(intent);
            }
        });

    }
    public void lear(){
        Fangwen.ll.clear();
    }

}
