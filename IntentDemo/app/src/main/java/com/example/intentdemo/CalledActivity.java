package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalledActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called);
        Intent intent =getIntent();
       // String un=intent.getStringExtra("userName");
     //   String pwd=intent.getStringExtra("password");
        Bundle bundle=intent.getExtras();
       String user= bundle.getString("userName");
       String pass=bundle.getString("password");
        Toast.makeText(this, "Welcome " + user, Toast.LENGTH_SHORT).show();
        TextView tv=findViewById(R.id.tvMessage);
        tv.setText("Welcome " + user);
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(CalledActivity.this,MainActivity.class);
                intent1.putExtra("Result","Success");
                setResult(2, intent1);
                finish();
            }
        });
    }
}