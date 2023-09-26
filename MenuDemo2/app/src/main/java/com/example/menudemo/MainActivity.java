package com.example.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textView;
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       setSupportActionBar(findViewById(R.id.main_toolbar));
       // supportActionBar.setTitle("");
        textView=findViewById(R.id.tv);
        registerForContextMenu(textView);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setForceShowIcon(true);
                popupMenu.show();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // MenuInflater menuInflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


               if (item.getItemId() == R.id.dance)
            Toast.makeText(this, "You opted for dance", Toast.LENGTH_SHORT).show();
        if (item.getItemId() == R.id.karnatakaMusic)
            Toast.makeText(this, "you selected karnataka music", Toast.LENGTH_SHORT).show();
        if (item.getItemId() == R.id.classical)
            Toast.makeText(this, "you selected classical", Toast.LENGTH_SHORT).show();
        if (item.getItemId() == R.id.play)
            Toast.makeText(this, "you selected play", Toast.LENGTH_SHORT).show();



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.options_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.dance)
            Toast.makeText(this, "You opted for dance", Toast.LENGTH_SHORT).show();
        if (item.getItemId() == R.id.karnatakaMusic)
            Toast.makeText(this, "you selected karnataka music", Toast.LENGTH_SHORT).show();
        if (item.getItemId() == R.id.classical)
            Toast.makeText(this, "you selected classical", Toast.LENGTH_SHORT).show();
        if (item.getItemId() == R.id.play)
            Toast.makeText(this, "you selected play", Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}
