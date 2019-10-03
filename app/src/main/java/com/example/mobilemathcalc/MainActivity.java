package com.example.mobilemathcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double leftNum;
    private char operator;
    private double rightNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numberButtonClicked(View v){
        Button B = (Button)v;

        TextView t = (TextView)findViewById(R.id.textView);

        t.setText(t.getText().toString() + B.getText());


    }

    public void operatorButtonClicked(View v){
        Button B = (Button)v;

        operator = B.getText().charAt(0);

        TextView t = (TextView)findViewById(R.id.textView);

        leftNum = Double.parseDouble(t.getText().toString());

        t.setText("");
    }

    public void pressEquals(View v){
        Button B = (Button)v;

        TextView t = (TextView)findViewById(R.id.textView);

        rightNum = Double.parseDouble(t.getText().toString());

        t.setText(Double.toString(Calculator.Calculate(leftNum,operator,rightNum)));


    }

    public void pressClear(View v){
        Button B =(Button)v;

        leftNum= 0;
        operator = ' ';
        rightNum = 0;

        TextView t = (TextView)findViewById(R.id.textView);

        t.setText("");

    }

    public void pressDecimal(View v){
        Button B = (Button)v;

        TextView t = (TextView)findViewById(R.id.textView);

        if(!t.getText().toString().contains(".")){
            t.setText(t.getText().toString() + B.getText());
        }
    }

    public void pressNegativePositive(View v){
        Button B = (Button)v;

        TextView t = (TextView)findViewById(R.id.textView);

        if(!t.getText().toString().contains("-")){
            t.setText("-" + t.getText().toString());
        }else{
            t.setText((t.getText().toString().substring(1)));
        }
    }

    public void pressBack (View v){
        Button B = (Button)v;

        TextView t = (TextView)findViewById(R.id.textView);



        if(t.getText().length() != 0){
            t.setText((t.getText().toString().substring(0,t.getText().length()-1)));
        }
    }
}
