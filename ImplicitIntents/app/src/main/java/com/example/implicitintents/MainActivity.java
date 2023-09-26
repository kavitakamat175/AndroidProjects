package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lv);
        et=findViewById(R.id.etNumber);

        String[] listItems=new String[]{"Call this number", "Show Map", "Send SMS", "Set Alarm", "Search Google"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItems);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(parent.getItemAtPosition(position).toString())
                {
                    case "Call this number" :
                String number=et.getText().toString();
                        Intent intent1=new Intent(Intent.ACTION_DIAL);
                        intent1.setData(Uri.parse("tel:"+number));
                        startActivity(intent1);
                        break;
                    case "Show Map":
                        Intent intent2=new Intent(Intent.ACTION_VIEW);
                        intent2.setData(Uri.parse("geo:18.645296,73.791373"));
                        Intent choice=Intent.createChooser(intent2,"Lauch Map");
                        startActivity(choice);
                        break;
                    case "Send SMS":
                       String smsnum=et.getText().toString();
                        Intent intent3=new Intent(Intent.ACTION_SENDTO);
                        intent3.setData(Uri.parse("smsto:"+ smsnum));
                        intent3.putExtra("sms_body","Hi !!!");
                        startActivity(intent3);
                        break;
                    case "Set Alarm":
                        Intent intent4 = new Intent(AlarmClock.ACTION_SET_ALARM)
                                .putExtra(AlarmClock.EXTRA_MESSAGE, "Set alarm from my app")
                                .putExtra(AlarmClock.EXTRA_HOUR, 15)
                                .putExtra(AlarmClock.EXTRA_MINUTES, 24);
                        if (intent4.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent4);
                        }

                        break;
                    case "Search Google":
                        Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                        startActivity(intent5);
                        break;
                }

            }
        });
    }
}