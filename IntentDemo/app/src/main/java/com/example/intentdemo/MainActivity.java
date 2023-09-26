package com.example.intentdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etUN, etPWD;
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUN = findViewById(R.id.etUserName);
        etPWD = findViewById(R.id.etPassword);
        btn = findViewById(R.id.btnSubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = etUN.getText().toString();
                String pwd = etPWD.getText().toString();

                Intent intent = new Intent(MainActivity.this, CalledActivity.class);
                intent.putExtra("userName", un);
                intent.putExtra("password", pwd);
              //  startActivity(intent);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==2)
        {
            String msg= data.getStringExtra("Result");
            Toast.makeText(this, "Welcome Back " + msg, Toast.LENGTH_SHORT).show();
        }
    }
}