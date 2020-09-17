package com.example.jisuanqi;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityChangdu extends AppCompatActivity implements View.OnClickListener {
    Button bt_num1, bt_num2, bt_num3, bt_num4, bt_num5, bt_num6, bt_num7,
            bt_num8, bt_num9, bt_num0, bt_m, bt_mm, bt_cm, bt_dm, bt_clear,
            bt_dian, bt_BB, bt_EE;
    private EditText danwei1, danwei2, k1, k2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.longdu);
        showq();
    }

    private void showq() {
        bt_num0 = (Button) findViewById(R.id.button11);
        bt_num0.setOnClickListener(this);

        bt_num1 = (Button) findViewById(R.id.button22);
        bt_num1.setOnClickListener(this);


        bt_num2 = (Button) findViewById(R.id.button33);
        bt_num2.setOnClickListener(this);

        bt_num3 = (Button) findViewById(R.id.button44);
        bt_num3.setOnClickListener(this);

        bt_num4 = (Button) findViewById(R.id.button55);
        bt_num4.setOnClickListener(this);

        bt_num5 = (Button) findViewById(R.id.button66);
        bt_num5.setOnClickListener(this);

        bt_num6 = (Button) findViewById(R.id.button77);
        bt_num6.setOnClickListener(this);

        bt_num7 = (Button) findViewById(R.id.button88);
        bt_num7.setOnClickListener(this);

        bt_num8 = (Button) findViewById(R.id.button99);
        bt_num8.setOnClickListener(this);

        bt_num9 = (Button) findViewById(R.id.button00);
        bt_num9.setOnClickListener(this);


        bt_dian = (Button) findViewById(R.id.button_dian);
        bt_dian.setOnClickListener(this);

        danwei1 = (EditText) findViewById(R.id.danwei1);
        danwei2 = (EditText) findViewById(R.id.danwei2);
        k1 = (EditText) findViewById(R.id.k1);
        k2 = (EditText) findViewById(R.id.k2);

        bt_dm = (Button) findViewById(R.id.button_dm);
        bt_dm.setOnClickListener(this);


        bt_clear = (Button) findViewById(R.id.button_clear);
        bt_clear.setOnClickListener(this);

        bt_m = (Button) findViewById(R.id.button_m);
        bt_m.setOnClickListener(this);


        bt_cm = (Button) findViewById(R.id.button_cm);
        bt_cm.setOnClickListener(this);

        bt_mm = (Button) findViewById(R.id.button_mm);
        bt_mm.setOnClickListener(this);



        bt_EE= (Button) findViewById(R.id.button_EE);
        bt_EE.setOnClickListener(this);
        bt_BB=(Button)findViewById(R.id.buttonBB);
        bt_BB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String lasttext;
        boolean now;
        String ll=k1.getText().toString();
        switch (v.getId()) {
            case R.id.button00:
                k1.setText(k1.getText() + "0");
                now = false;
                break;
            case R.id.button11:
                k1.setText(k1.getText() + "1");
                now = false;
                break;
            case R.id.button22:
                k1.setText(k1.getText() + "2");
                now = false;
                break;
            case R.id.button33:
                k1.setText(k1.getText() + "3");
                now = false;
                break;
            case R.id.button44:
                k1.setText(k1.getText() + "4");
                now = false;
                break;
            case R.id.button55:
                k1.setText(k1.getText() + "5");
                now = false;
                break;
            case R.id.button66:
                k1.setText(k1.getText() + "6");
                now = false;
                break;
            case R.id.button77:
                k1.setText(k1.getText() + "7");
                now = false;
                break;
            case R.id.button88:
                k1.setText(k1.getText() + "8");
                now = false;
                break;
            case R.id.button_cm:
                danwei1.setText("cm");
                now = false;
                break;
            case R.id.button_mm:
                danwei1.setText("mm");
                now = false;
                break;
            case R.id.button_m:
                danwei2.setText("m");
                now = false;
                break;
            case R.id.button_dm:
                danwei2.setText("dm");
                now = false;
                break;
            case R.id.button99:
                k1.setText(k1.getText() + "9");
                now = false;
                break;
            case R.id.button_clear:
                k1.setText("");
                danwei2.setText("");
                k2.setText("");
                danwei1.setText("");
                break;
            case R.id.buttonBB:
                if (ll!=null&&!ll.equals("")) {
                    k1.setText(ll.substring(0, ll.length() - 1));
                }
                break;
            case R.id.button_EE:
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
        if(s2.equals("dm")){
            if(s1.equals("mm")){
                m2=0.01*m1;
            }
            else{
                m2=0.1*m1;
            }
        }
        else {
            if(s1.equals("mm")){
                m2=0.001*m1;
            }
            else{
                m2=0.01*m1;
            }
        }
        return m2+"";
    }
}
