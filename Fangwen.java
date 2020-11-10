package com.example.connectperson;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Fangwen extends AppCompatActivity {
   // ArrayAdapter<String> adapter;
    public  static List<String> contactsList=new ArrayList<>();
    public  static List<String> ll=new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lianxirenjiemian);
        final ListView contactsView= (ListView) findViewById(R.id.contacts_view);
        final MyAdapter adapter = new MyAdapter(Fangwen.this, contactsList);
        contactsView.setAdapter(adapter);
       // adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList);
        contactsView.setAdapter(adapter);
        //判断是否开启读取通讯录的权限
        contactsList.clear();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager
                .PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
        }else {
            readContacts();
        }

        contactsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ll.clear();
                ll.add(contactsList.get(i));
                Intent intent = new Intent();
                intent.setClass(Fangwen.this, modification.class);
                intent.putExtra("name", "xiazdong");
                startActivity(intent);

                contactsList.set(i,modification.lll.toString());
                modification.lll.clear();
            }
        });
        adapter.setOnItemDeleteClickListener(new MyAdapter.onItemDeleteListener() {
            @Override
            public void onDeleteClick(int i) {
                contactsList.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
    }



        private void readContacts() {
        Cursor cursor=null;
        try {

            cursor=getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    null,
                    null,
                    null
            );
            if (cursor!=null){
                while (cursor.moveToNext()){
                    //获取联系人姓名
                    String displayName=cursor.getString(cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                    ));
                    //获取联系人手机号
                    String number=cursor.getString(cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                    ));
                    //把取出的两类数据进行拼接，中间加换行符，然后添加到listview中
                    contactsList.add(displayName+"\n"+number);
                }
                //刷新listview
               //adapter.notifyDataSetChanged();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //记得关掉cursor
            if (cursor!=null){
                cursor.close();
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    readContacts();
                }else {
                    Toast.makeText(this,"没有权限",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
