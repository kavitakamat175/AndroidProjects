package com.example.customviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
String[] arr=new String[]{"Apple","Orange","Watermelon","Coconut"};
int[] ids={R.drawable.apple,R.drawable.orange,R.drawable.watermelon,R.drawable.coconut};
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lv);
      //  ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
  //      listView.setAdapter(arrayAdapter);
        CustomAdapter customAdapter=new CustomAdapter(this,arr,ids);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You have selected " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}