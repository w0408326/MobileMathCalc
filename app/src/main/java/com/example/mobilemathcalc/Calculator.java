package com.example.mobilemathcalc;

public class Calculator {
    public static double Calculate(double leftNum, char operator, double rightNum){

        switch (operator) {
            case ' ':
                return leftNum;
            case '+':
                return leftNum + rightNum;
            case '-':
                return leftNum - rightNum;
            case 'X':
                return leftNum * rightNum;
            case '/':
                if(rightNum == 0){
                    leftNum = 0;
                }
                return leftNum / rightNum;
        }
        return 0;
    }


}
