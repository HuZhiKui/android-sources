package com.example.jisuanqi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityTiji extends AppCompatActivity implements View.OnClickListener {
    Button bt_num1, bt_num2, bt_num3, bt_num4, bt_num5, bt_num6, bt_num7,
            bt_num8, bt_num9, bt_num0, bt_m, bt_mm, bt_cm, bt_dm, bt_clear,
            bt_dian, bt_BB, bt_EE;
    private EditText danwei1, danwei2, k1, k2;
    int n,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiji);
        showq();
    }

    private void showq() {
        bt_num0 = (Button) findViewById(R.id.button111);
        bt_num0.setOnClickListener(this);

        bt_num1 = (Button) findViewById(R.id.button222);
        bt_num1.setOnClickListener(this);


        bt_num2 = (Button) findViewById(R.id.button333);
        bt_num2.setOnClickListener(this);

        bt_num3 = (Button) findViewById(R.id.button444);
        bt_num3.setOnClickListener(this);

        bt_num4 = (Button) findViewById(R.id.button555);
        bt_num4.setOnClickListener(this);

        bt_num5 = (Button) findViewById(R.id.button666);
        bt_num5.setOnClickListener(this);

        bt_num6 = (Button) findViewById(R.id.button777);
        bt_num6.setOnClickListener(this);

        bt_num7 = (Button) findViewById(R.id.button888);
        bt_num7.setOnClickListener(this);

        bt_num8 = (Button) findViewById(R.id.button999);
        bt_num8.setOnClickListener(this);

        bt_num9 = (Button) findViewById(R.id.button000);
        bt_num9.setOnClickListener(this);


        bt_dian = (Button) findViewById(R.id.button_diann);
        bt_dian.setOnClickListener(this);

        danwei1 = (EditText) findViewById(R.id.danwei11);
        danwei2 = (EditText) findViewById(R.id.danwei22);
        k1 = (EditText) findViewById(R.id.k11);
        k2 = (EditText) findViewById(R.id.k22);

        bt_dm = (Button) findViewById(R.id.button_dmm);
        bt_dm.setOnClickListener(this);
        b=3;

        bt_clear = (Button) findViewById(R.id.button_clearr);
        bt_clear.setOnClickListener(this);

        bt_m = (Button) findViewById(R.id.button_mm);
        bt_m.setOnClickListener(this);
        b=4;

        bt_cm = (Button) findViewById(R.id.button_cmm);
        bt_cm.setOnClickListener(this);
        n=2;

        bt_mm = (Button) findViewById(R.id.button_mmm);
        bt_mm.setOnClickListener(this);
        n=1;


        bt_EE= (Button) findViewById(R.id.button_EEE);
        bt_EE.setOnClickListener(this);
        bt_BB=(Button)findViewById(R.id.buttonBBB);
        bt_BB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String lasttext;
        boolean now;
        String ll=k1.getText().toString();
        switch (v.getId()) {
            case R.id.button000:
                k1.setText(k1.getText() + "0");
                now = false;
                break;
            case R.id.button111:
                k1.setText(k1.getText() + "1");
                now = false;
                break;
            case R.id.button222:
                k1.setText(k1.getText() + "2");
                now = false;
                break;
            case R.id.button333:
                k1.setText(k1.getText() + "3");
                now = false;
                break;
            case R.id.button444:
                k1.setText(k1.getText() + "4");
                now = false;
                break;
            case R.id.button555:
                k1.setText(k1.getText() + "5");
                now = false;
                break;
            case R.id.button666:
                k1.setText(k1.getText() + "6");
                now = false;
                break;
            case R.id.button777:
                k1.setText(k1.getText() + "7");
                now = false;
                break;
            case R.id.button888:
                k1.setText(k1.getText() + "8");
                now = false;
                break;
            case R.id.button_cmm:
                danwei1.setText("立方厘米");
                now = false;
                break;
            case R.id.button_mmm:
                danwei1.setText("立方毫米");
                now = false;
                break;
            case R.id.button_mm:
                danwei2.setText("立方米");
                now = false;
                break;
            case R.id.button_dmm:
                danwei2.setText("立方分米");
                now = false;
                break;
            case R.id.button999:
                k1.setText(k1.getText() + "9");
                now = false;
                break;
            case R.id.button_clearr:
                k1.setText("");
                danwei2.setText("");
                k2.setText("");
                danwei1.setText("");
                break;
            case R.id.buttonBBB:
                if (ll!=null&&!ll.equals("")) {
                    k1.setText(ll.substring(0, ll.length() - 1));
                }
                break;
            case R.id.button_EEE:
                k1.setText(k1.getText());
                lasttext = k1.getText().toString();
                String a1 = huans(danwei1.toString(),danwei2.toString(),k1.getText().toString());
                k2.setText(a1);
                break;
        }


    }
    public String huans(String s1,String s2,String s3){
        double m1=Double.parseDouble(s3);
        double m2;
        if(s2.equals("立方米")){
            if(s1.equals("立方毫米")){
                m2=1000000000*m1;
            }
            else{
                m2=1000000*m1;
            }
        }
        else {
            if(s1.equals("立方毫米")){
                m2=1000000*m1;
            }
            else{
                m2=1000*m1;
            }
        }
        return m2+"";
    }
}
