package com.example.connectperson;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity   {

    private TextView vvv;
    private EditText search2;
    private Button search;
    private EditText search1;
    private Button shanchu;
    TextView vie;
    ArrayAdapter<String> adapter;
    List<String> contactsList=new ArrayList<>();
    List<String> searchlist=new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        search1 = (EditText) findViewById(R.id.et_eeee);
        search = (Button) findViewById(R.id.btn_search);
        search2=(EditText) findViewById(R.id.et_eeee1);
        vvv=(TextView)findViewById(R.id.btn_viieeww);
        search.setOnClickListener(new dianjii());
        shanchu=(Button)findViewById(R.id.shanchu);
        shanchu.setOnClickListener(new shanc());
        // TODO Auto-generated method stub
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager
                .PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
        }else {
            readContacts();
        }
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
                adapter.notifyDataSetChanged();

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

    private class dianjii implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if(search1.getText().toString()==""&&search2.getText().toString()==""){
                searchlist.add("请输入姓名或电话进行查询");
            }
            else if(search1.getText().toString()!=""&&search2.getText().toString()==""){
                for(int i=0;i<contactsList.size();i++) {
                    if (contactsList.get(i).contains(search1.getText().toString())) {
                        searchlist.add(contactsList.get(i));
                    }

                }
            }
            else if(search1.getText().toString()!=""&&search2.getText().toString()!=""){
                for(int i=0;i<contactsList.size();i++) {
                    if (contactsList.get(i).contains(search1.getText().toString()+search2.getText().toString())) {
                        searchlist.add(contactsList.get(i));
                    }

                }

            }else {
                for (int i = 0; i < contactsList.size(); i++) {
                    if (contactsList.get(i).equals(search2.getText().toString())) {
                        searchlist.add(contactsList.get(i));
                    }

                }
            }
            if(searchlist.isEmpty()){
                searchlist.add("查询无果");
            }
            vvv.setText(searchlist.toString());
        }
    }

    private class shanc implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            searchlist.clear();
            vvv.setText("");
        }
    }
}