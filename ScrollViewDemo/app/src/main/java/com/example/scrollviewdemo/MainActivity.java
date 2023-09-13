package com.example.scrollviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
tv=findViewById(R.id.tvContent);
tv.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
//tv.setTextAlignment();
    }
}