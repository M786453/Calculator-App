package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private enum OPERATOR{
       PLUS,SUBTRACT,MULTIPLY,DIVIDE,EQUAL
   }
    private Button btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,
            btnSix,btnSeven,btnEight,btnNine,btnDivide,btnMultiply,
            btnMinus,btnAdd,btnEqual,btnPoint,btnClear;
   private  OPERATOR currentOperator;
    private TextView txtValues,txtExpression;
    private String stringCurrentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private int calculationResult;
    private String calculations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stringCurrentNumber = "";
        calculationResult = 0;
        calculations = "";
        findViewById(R.id.btnZero).setOnClickListener(this);
        findViewById(R.id.btnOne).setOnClickListener(this);
        findViewById(R.id.btnTwo).setOnClickListener(this);
        findViewById(R.id.btnThree).setOnClickListener(this);
        findViewById(R.id.btnFour).setOnClickListener(this);
        findViewById(R.id.btnFive).setOnClickListener(this);
        findViewById(R.id.btnSix).setOnClickListener(this);
        findViewById(R.id.btnSeven).setOnClickListener(this);
        findViewById(R.id.btnEight).setOnClickListener(this);
        findViewById(R.id.btnNine).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnMulti).setOnClickListener(this);
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnEqual).setOnClickListener(this);
        txtValues = findViewById(R.id.txtValues);
        txtExpression = findViewById(R.id.txtExpression);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnZero:
               tappedNumbers(0);
                break;
            case R.id.btnOne:
               tappedNumbers(1);
                break;
            case R.id.btnTwo:
                tappedNumbers(2);
                break;
            case R.id.btnThree:
           tappedNumbers(3);
                break;
            case R.id.btnFour:
           tappedNumbers(4);
                break;
            case R.id.btnFive:
           tappedNumbers(5);
                break;
            case R.id.btnSix:
           tappedNumbers(6);
                break;
            case R.id.btnSeven:
           tappedNumbers(7);
                break;
            case R.id.btnEight:
            tappedNumbers(8);
                break;
            case R.id.btnNine:
           tappedNumbers(9);
                break;
            case R.id.btnDiv:
            operatorIsTapped(OPERATOR.DIVIDE);
            calculations += " / ";
                break;
            case R.id.btnMulti:
           operatorIsTapped(OPERATOR.MULTIPLY);
                calculations += " * ";
                break;
            case R.id.btnAdd:
           operatorIsTapped(OPERATOR.PLUS);
                calculations += " + ";
                break;
            case R.id.btnMinus:
           operatorIsTapped(OPERATOR.SUBTRACT);
                calculations += " - ";
                break;

            case R.id.btnEqual:
           operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.btnClear:
            clearTapped();

        }
        txtExpression.setText(calculations);
    }
   private void tappedNumbers(int tappedNumber){
        stringCurrentNumber = stringCurrentNumber + String.valueOf(tappedNumber);
        txtValues.setText(stringCurrentNumber);
        calculations = stringCurrentNumber;
        txtExpression.setText(calculations);
   }
   private void operatorIsTapped(OPERATOR tappedOperator){
        if (currentOperator != null ){
            if (stringCurrentNumber != "") {
                stringNumberAtRight = stringCurrentNumber;
                stringCurrentNumber = "";
                switch (currentOperator) {
                    case PLUS:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) +
                                Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBTRACT:
                        calculationResult = Integer.parseInt(stringNumberAtLeft)
                                - Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult = Integer.parseInt(stringNumberAtLeft)
                                / Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResult = Integer.parseInt(stringNumberAtLeft)
                                * Integer.parseInt(stringNumberAtRight);
                        break;
                }
                stringNumberAtLeft = String.valueOf(calculationResult);
                txtValues.setText(stringNumberAtLeft);
                calculations = stringNumberAtLeft;
                txtExpression.setText(calculations);
            }
        }else{
            stringNumberAtLeft = stringCurrentNumber;
            stringCurrentNumber = "";
        }
        currentOperator = tappedOperator;
   }
   private void clearTapped(){
        currentOperator = null;
        stringCurrentNumber = "";
       calculationResult = 0;
        txtValues.setText("0");
        stringNumberAtRight = "";
        stringNumberAtLeft = "";
        calculations = "0";
   }
}

