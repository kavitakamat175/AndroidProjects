package com.example.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editText;
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.etUserName);

    }

    public void callme(View view) {
        String name=editText.getText().toString();
        Toast.makeText(this, "You entered " + name, Toast.LENGTH_LONG).show();
    }
}