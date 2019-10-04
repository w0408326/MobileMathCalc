package com.example.mobilemathcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // global variables for the equations
    private Double leftNum;
    private char operator;
    private Double rightNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // function called for numbers 0-9 when they're pressed
    public void numberButtonClicked(View v){
        Button b = (Button)v;

        TextView t = (TextView)findViewById(R.id.textView);

        if(t.getText().toString().matches("0") && b.getText().toString().matches("0")){
            //prevents 0 from being clicked multiple times
        }else{
            //sets the display area to append the number button pressed
            t.setText(t.getText().toString() + b.getText());
        }
    }

    // function called for when operators are pressed
    public void operatorButtonClicked(View v){
        Button b = (Button)v;
        TextView t = (TextView)findViewById(R.id.textView);

        operator = ' '; // clears the operator
        operator = b.getText().charAt(0); // assigns operator to button pressed

        // if display area isn't empty and left number hasn't been assigned
        if(!t.getText().toString().matches("") && leftNum == null){
            // left number is assigned the number in display area
            leftNum = Double.parseDouble(t.getText().toString());
            // clear display area
            t.setText("");
        // if left number is assigned, display area isn't empty, and right number isn't assigned
        }else if(leftNum != null && !t.getText().toString().matches("") && rightNum == null){
            //  assign right number if operator is clicked before equals but after number has been pressed
            rightNum = Double.parseDouble(t.getText().toString());
            t.setText(Double.toString(Calculator.Calculate(leftNum,operator,rightNum)));
            // assign the answer as the new left number
            leftNum = Double.parseDouble(t.getText().toString());
        }else if(!t.getText().toString().matches("")){
            leftNum = Double.parseDouble(t.getText().toString());
            t.setText("");
        }
    }

    // function called when equals is pressed
    public void pressEquals(View v){
        TextView t = findViewById(R.id.textView);

        if(leftNum == null){
            // if there's no left number do nothing
        }
        // if display view isn't empty and left number is filled
        else if(!t.getText().toString().matches("")){
            // assign right number to display view number
            rightNum = Double.parseDouble(t.getText().toString());
            // perform calculation
            t.setText(Double.toString(Calculator.Calculate(leftNum,operator,rightNum)));
            // set the answer to new left number
            leftNum = Double.parseDouble(t.getText().toString());
        }
    }

    // function when clear button is pressed
    public void pressClear(View v){
        // clears all global variables
        leftNum = null;
        operator = ' ';
        rightNum = null;

        TextView t = (TextView)findViewById(R.id.textView);

        // clears display view
        t.setText("");
    }

    // function when decimal button is pressed
    public void pressDecimal(View v){
        Button b = (Button)v;

        TextView t = (TextView)findViewById(R.id.textView);

        // if statement to prevent multiple decimals or decimals before a number is pressed
        if(!t.getText().toString().contains(".") & !t.getText().toString().matches("")){
            t.setText(t.getText().toString() + b.getText());
        }
    }

    // function for when positive/negative button is pressed
    public void pressNegativePositive(View v){
        TextView t = (TextView)findViewById(R.id.textView);

        // put "-" at the front of the string if it's not already there
        if(!t.getText().toString().contains("-")){
            t.setText("-" + t.getText().toString());
        }
        // if there is a "-" remove it
        else {
            t.setText((t.getText().toString().substring(1)));
        }
    }

    // function for when back button is pressed
    public void pressBack (View v){
        TextView t = findViewById(R.id.textView);

        // if the string isn't length 0 remove one character off the end
        if(t.getText().length() != 0){
            t.setText((t.getText().toString().substring(0,t.getText().length()-1)));
        }
    }
}
