package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1=findViewById(R.id.button1),button2=findViewById(R.id.button2),button3=findViewById(R.id.button3), button4=findViewById(R.id.button4),
            button5=findViewById(R.id.button5),button6=findViewById(R.id.button6),button7=findViewById(R.id.button7),button8=findViewById(R.id.button8),
            button9=findViewById(R.id.button9),button0=findViewById(R.id.button0),button00=findViewById(R.id.button00);
    Button button_aa=findViewById(R.id.button_aa),button_bb=findViewById(R.id.button_bb),button_cc=findViewById(R.id.button_cc),button_dd=findViewById(R.id.button_dd);
    Button buttonA=findViewById(R.id.buttonA),buttonB=findViewById(R.id.buttonB),buttonD=findViewById(R.id.buttonD),buttonC=findViewById(R.id.buttonC);
    boolean isEmpty;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
