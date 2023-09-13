package com.example.viewsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
        RadioGroup rg;
        ToggleButton tb;
        RatingBar rb;
        Switch aswitch;
        Spinner spinner;
        SeekBar seekBar;
        ProgressBar pbar;
        AutoCompleteTextView actv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 /*       rg = findViewById(R.id.rgGender);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "You Selected "+rb.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        tb = findViewById(R.id.tb);
        rb = findViewById(R.id.rating);
        aswitch = findViewById(R.id.aswitch);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String text = tb.getText().toString();
                    Toast.makeText(MainActivity.this, ""+text,
                            Toast.LENGTH_SHORT).show();
                    tb.setTextOff("Image Off");

                }else{
                    tb.setTextOn("Image is Displayed");
                }
            }
        });

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "You Selected "+String.valueOf(rating)+
                        " Stars", Toast.LENGTH_SHORT).show();
            }
        });

        aswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    aswitch.setText("Music Started");
                }else{
                    aswitch.setText("Music Stoped");
                }
            }
        });
*/
              spinner = findViewById(R.id.spinner);
        //seekBar = findViewById(R.id.seekBar);
        //pbar = findViewById(R.id.progressBar);
        actv = findViewById(R.id.actv);

        String cities[] = new String[]{"Pune","Patna","Patliputra","Pandharpur"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,cities );
        actv.setAdapter(arrayAdapter);

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You have selected " +
                        parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You selected " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}