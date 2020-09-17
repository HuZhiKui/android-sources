package com.example.jisuanqi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class MainActivityJinzhi extends AppCompatActivity implements View.OnClickListener {
    Button bt_num1, bt_num2, bt_num3, bt_num4, bt_num5, bt_num6, bt_num7,
            bt_num8, bt_num9, bt_num0, bt_m, bt_mm, bt_cm, bt_dm, bt_clear,
            bt_dian, bt_BB, bt_EE;
    private EditText danwei1, danwei2, k1, k2;
    int n,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jinzhi);
        showq();
    }

    private void showq() {
        bt_num0 = (Button) findViewById(R.id.button1111);
        bt_num0.setOnClickListener(this);

        bt_num1 = (Button) findViewById(R.id.button2222);
        bt_num1.setOnClickListener(this);


        bt_num2 = (Button) findViewById(R.id.button3333);
        bt_num2.setOnClickListener(this);

        bt_num3 = (Button) findViewById(R.id.button4444);
        bt_num3.setOnClickListener(this);

        bt_num4 = (Button) findViewById(R.id.button5555);
        bt_num4.setOnClickListener(this);

        bt_num5 = (Button) findViewById(R.id.button6666);
        bt_num5.setOnClickListener(this);

        bt_num6 = (Button) findViewById(R.id.button7777);
        bt_num6.setOnClickListener(this);

        bt_num7 = (Button) findViewById(R.id.button8888);
        bt_num7.setOnClickListener(this);

        bt_num8 = (Button) findViewById(R.id.button9999);
        bt_num8.setOnClickListener(this);

        bt_num9 = (Button) findViewById(R.id.button0000);
        bt_num9.setOnClickListener(this);


        bt_dian = (Button) findViewById(R.id.button_diannn);
        bt_dian.setOnClickListener(this);

        danwei1 = (EditText) findViewById(R.id.danwei111);
        danwei2 = (EditText) findViewById(R.id.danwei222);
        k1 = (EditText) findViewById(R.id.k111);
        k2 = (EditText) findViewById(R.id.k222);

        bt_dm = (Button) findViewById(R.id.button_dmmm);
        bt_dm.setOnClickListener(this);
        b=3;

        bt_clear = (Button) findViewById(R.id.button_clearrr);
        bt_clear.setOnClickListener(this);

        bt_m = (Button) findViewById(R.id.button_mmm);
        bt_m.setOnClickListener(this);
        b=4;

        bt_cm = (Button) findViewById(R.id.button_cmmm);
        bt_cm.setOnClickListener(this);
        n=2;

        bt_mm = (Button) findViewById(R.id.button_mmmm);
        bt_mm.setOnClickListener(this);
        n=1;


        bt_EE= (Button) findViewById(R.id.button_EEEE);
        bt_EE.setOnClickListener(this);
        bt_BB=(Button)findViewById(R.id.buttonBBBB);
        bt_BB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String lasttext;
        boolean now;
        String ll=k1.getText().toString();
        switch (v.getId()) {
            case R.id.button0000:
                k1.setText(k1.getText() + "0");
                now = false;
                break;
            case R.id.button1111:
                k1.setText(k1.getText() + "1");
                now = false;
                break;
            case R.id.button2222:
                k1.setText(k1.getText() + "2");
                now = false;
                break;
            case R.id.button3333:
                k1.setText(k1.getText() + "3");
                now = false;
                break;
            case R.id.button4444:
                k1.setText(k1.getText() + "4");
                now = false;
                break;
            case R.id.button5555:
                k1.setText(k1.getText() + "5");
                now = false;
                break;
            case R.id.button6666:
                k1.setText(k1.getText() + "6");
                now = false;
                break;
            case R.id.button7777:
                k1.setText(k1.getText() + "7");
                now = false;
                break;
            case R.id.button8888:
                k1.setText(k1.getText() + "8");
                now = false;
                break;
            case R.id.button_cmmm:
                danwei1.setText("四");
                now = false;
                break;
            case R.id.button_mmmm:
                danwei1.setText("十");
                now = false;
                break;
            case R.id.button_mmm:
                danwei2.setText("二");
                now = false;
                break;
            case R.id.button_dmmm:
                danwei2.setText("八");
                now = false;
                break;
            case R.id.button9999:
                k1.setText(k1.getText() + "9");
                now = false;
                break;
            case R.id.button_clearrr:
                k1.setText("");
                danwei2.setText("");
                k2.setText("");
                danwei1.setText("");
                break;
            case R.id.buttonBBBB:
                if (ll!=null&&!ll.equals("")) {
                    k1.setText(ll.substring(0, ll.length() - 1));
                }
                break;
            case R.id.button_EEEE:
                k1.setText(k1.getText());
                lasttext = k1.getText().toString();
                String a1 = huans(danwei1.toString(),danwei2.toString(),k1.getText().toString());
                k2.setText(a1);
                break;
        }


    }
    public String huans(String s1,String s2,String s3){
        double m1=Double.parseDouble(s3);
        String c;
        if(s1.equals("四")){
            if(s2.equals("二")){
                String a= new BigInteger(s3,10).toString(4);
                c= new BigInteger(a,4).toString(2);
            }
            else{
                String a= new BigInteger(s3,10).toString(4);
                c= new BigInteger(a,4).toString(8);
            }
        }
        else {
            if(s2.equals("二")){
                String a= new BigInteger(s3,10).toString(8);
                c= new BigInteger(a,8).toString(2);
            }
            else{
                String a= new BigInteger(s3,10).toString(8);
                c= new BigInteger(a,8).toString(10);
            }
        }
        return c;
    }
}
