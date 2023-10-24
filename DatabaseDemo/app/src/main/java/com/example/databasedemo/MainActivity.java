package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
Button btn;
DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.etEmpcode);
        et2=findViewById(R.id.etEmpName);
        btn=findViewById(R.id.btnAddRec);
        dbHelper=new DBHelper(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ecode=Integer.parseInt(et1.getText().toString());
                String enm=et2.getText().toString();
                boolean result=dbHelper.addRec(ecode,enm);
                if(result)
                    Toast.makeText(MainActivity.this, "Record Added", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Error!! record not added", Toast.LENGTH_SHORT).show();
            }
        });

    }
}