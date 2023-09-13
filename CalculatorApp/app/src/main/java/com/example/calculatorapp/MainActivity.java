package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    TextView tv;
    Button b1, b2, b3, b4;
    int result;
    int num1, num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.etNum1);
        et2 = findViewById(R.id.etNum2);
        tv = findViewById(R.id.tvResult);
        b1 = findViewById(R.id.btnAdd);
        b2 = findViewById(R.id.btnSub);
        b3 = findViewById(R.id.btnMult);
        b4 = findViewById(R.id.btnDiv);
    }

    public void callCalc(View view) {
        num1 = Integer.parseInt(et1.getText().toString());
        num2 = Integer.parseInt(et2.getText().toString());
        Button btn = findViewById(view.getId());
        String operation = btn.getText().toString();
        switch (operation) {
            case "+":
                result = num1 + num2;
                tv.setText(String.valueOf(result));
                break;
            case "-":
                result = num1 - num2;
                tv.setText(String.valueOf(result));
                break;
            case "*":
                result = num1 * num2;
                tv.setText(String.valueOf(result));
                break;
            case "/":
                if (num2 != 0)
                    result = num1 / num2;
                tv.setText(String.valueOf(result));
                break;
        }
    }
}