package com.example.connectperson;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MyHelper myHelper;
    private Button btnAdd;
    private Button btnQuery;
    private Button btnUpdate;
    private Button btnlook;
    private  Button boru;
    EditText phnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setBackgroundDrawableResource(R.drawable.b);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHelper = new MyHelper(this);
        phnum=(EditText)findViewById(R.id.phone_id);
        btnlook = (Button) findViewById(R.id.btn_look);
        btnlook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Fangwen.class);
                intent.putExtra("name", "xiazdong");
                startActivity(intent);
            }
        });
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, tianjia.class);
                intent.putExtra("name", "xiazdong");
                startActivity(intent);
            }
        });
        btnQuery = (Button) findViewById(R.id.btn_query);
        btnQuery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Search.class);
                intent.putExtra("name", "xiazdong");
                startActivity(intent);
            }
        });
//        btnUpdate=(Button)findViewById(R.id.)
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, modification.class);
//                intent.putExtra("name", "xiazdong");
//                startActivity(intent);
//            }
//        });
        boru=(Button)findViewById(R.id.btn_boru);
        boru.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phnum.getText().toString()));
                startActivity(intent);
            }
        });
    }

    class MyHelper extends SQLiteOpenHelper {


        public MyHelper(Context context) {
            super(context, "alan.db", null, 2);
        }

        @Override

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table person(id integer primary key autoincrement,name varchar(20),phone varchar(20) unique)");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}