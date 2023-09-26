package com.example.datetimepickerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4;
TextView tv1,tv2;
DatePicker datePicker;
TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btnShowDP);
        b2=findViewById(R.id.btnShowDate);
        b3=findViewById(R.id.btnShowTP);
        b4=findViewById(R.id.btnShowTime);
        timePicker=findViewById(R.id.tpPicker);
        datePicker=findViewById(R.id.dtPicker);
        tv1=findViewById(R.id.tvDate);
        tv2=findViewById(R.id.tvTime);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.setVisibility(View.VISIBLE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           tv1.setText(datePicker.getDayOfMonth() +"/" + (datePicker.getMonth()+1) +"/"  + datePicker.getYear());
            }
        });
    }
}