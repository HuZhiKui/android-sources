package com.example.connectperson;

import android.Manifest;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class tianjia  extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private static final String TAG = "ContactsWriteTest";
    private static final Uri RAW_CONTACTS_URI = ContactsContract.RawContacts.CONTENT_URI;
    private static final Uri DATA_URI = ContactsContract.Data.CONTENT_URI;
    private static final String ACCOUNT_TYPE = ContactsContract.RawContacts.ACCOUNT_TYPE;
    private static final String ACCOUNT_NAME = ContactsContract.RawContacts.ACCOUNT_NAME;
    private static final String RAW_CONTACT_ID = ContactsContract.Data.RAW_CONTACT_ID;
    private static final String MIMETYPE = ContactsContract.Data.MIMETYPE;
    private static final String NAME_ITEM_TYPE = ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE;
    private static final String DISPLAY_NAME = ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME;
    private static final String PHONE_ITEM_TYPE = ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE;
    private static final String PHONE_NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
    private static final String PHONE_TYPE = ContactsContract.CommonDataKinds.Phone.TYPE;
    private static final int PHONE_TYPE_MOBILE = ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE;
    private static final String AUTHORITY = ContactsContract.AUTHORITY;
    private EditText e1;
    private EditText e2;
    private Button tianjia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tianjia);

        tianjia=(Button)findViewById(R.id.btn_tianjia);
        e1 = (EditText) findViewById(R.id.et_name);
        e2 = (EditText) findViewById(R.id.et_phone);

        tianjia.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int hasWriteContactsPermisson = checkSelfPermission(
                        android.Manifest.permission.READ_CONTACTS);
                if(hasWriteContactsPermisson !=
                        PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]
                                    {Manifest.permission.WRITE_CONTACTS},
                            REQUEST_CODE_ASK_PERMISSIONS);
                    return;
                }

                Log.i("TEST", "button onClick");
                TextView TextView1=(TextView)findViewById(R.id.tv_show);
                ArrayList<ContentProviderOperation> operations = new ArrayList<ContentProviderOperation>();
                ContentProviderOperation operation = ContentProviderOperation.newInsert(RAW_CONTACTS_URI)
                        .withValue(ACCOUNT_TYPE, null)
                        .withValue(ACCOUNT_NAME, null)
                        .build();
                operations.add(operation);
                operation = ContentProviderOperation.newInsert(DATA_URI)
                        .withValueBackReference(RAW_CONTACT_ID, 0)
                        .withValue(MIMETYPE, NAME_ITEM_TYPE)
                        .withValue(DISPLAY_NAME,e1.getText().toString())
                        .build();
                operations.add(operation);
                operation = ContentProviderOperation.newInsert(DATA_URI)
                        .withValueBackReference(RAW_CONTACT_ID, 0)
                        .withValue(MIMETYPE, PHONE_ITEM_TYPE)
                        .withValue(PHONE_TYPE, PHONE_TYPE_MOBILE)
                        .withValue(PHONE_NUMBER, e2.getText().toString())
                        .build();
                operations.add(operation);
                ContentResolver resolver = getBaseContext().getContentResolver();
                ContentProviderResult[] results = null;
                try {
                    results = resolver.applyBatch(AUTHORITY, operations);
                } catch (RemoteException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (OperationApplicationException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                for (ContentProviderResult result : results) {
                    Log.i(TAG, result.uri.toString());
                    TextView1.setText("联系人添加成功"+result.uri.toString());
                }
            }
        });
    }
}




