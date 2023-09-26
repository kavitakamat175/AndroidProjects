package com.example.dialogdemos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
TextView tv;
DatePicker datePicker;
TimePicker timePicker;
Button b1,b2,b3,b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker=findViewById(R.id.datepicker);
        timePicker=findViewById(R.id.timepicker);
        tv=findViewById(R.id.textview);
b1=findViewById(R.id.btnShowDP);
b2=findViewById(R.id.btnShowDate);
b3=findViewById(R.id.btnShowTP);
b4=findViewById(R.id.btnShowTime);

      /*  AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("You Want to exit?")
                .setTitle("Alert !!!!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You want to exit!! good", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You want to be here!! bad choice", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You can't decide!! very bad", Toast.LENGTH_SHORT).show();

                    }
                });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        Calendar cldr=Calendar.getInstance();
        int day=cldr.get(Calendar.DAY_OF_MONTH);
        int mnth=cldr.get(Calendar.MONTH);
        int yr =cldr.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, android.R.style.Widget_Holo_Light, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv.setText(dayOfMonth + "/" + (month+1) + "/" + year);
            }
        },yr,mnth,day);


        datePickerDialog.show();*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.GONE);

                datePicker.setVisibility(View.VISIBLE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear());

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.setVisibility(View.GONE);
timePicker.setVisibility(View.VISIBLE);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(timePicker.getHour()+":"+timePicker.getMinute());

            }
        });
    }
}