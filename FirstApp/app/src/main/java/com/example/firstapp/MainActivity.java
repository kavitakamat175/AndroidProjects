package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private final String TAG="Main Activity";
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"On Create called");

        EditText editText =findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Toast.makeText(MainActivity.this, "in activity afterTextchanged event", Toast.LENGTH_SHORT).show();
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                Toast.makeText(MainActivity.this, "in activity before text changed event", Toast.LENGTH_SHORT).show();

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });



    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"On start called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"on stop called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"On resume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"on pause called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"on destroy called");

    }

    public void callFragment(View view) {
        FirstFragment fragment = new FirstFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.linearLayout, fragment, null)
                .setReorderingAllowed(true)
                .commit();


    }
}