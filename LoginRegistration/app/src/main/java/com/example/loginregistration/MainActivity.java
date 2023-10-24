package com.example.loginregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText etUn, etPwd, etCPwd, etEmail, etPhone;
    TextView tvDOB;
    Button btn, btnShow,btnUpdate,btnDelete;
DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUn = findViewById(R.id.etUn);
        etPwd = findViewById(R.id.etPwd);
        etCPwd = findViewById(R.id.etCPwd);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        dbHelper=new DBHelper(this);
        tvDOB = findViewById(R.id.tvDOB);
      tvDOB.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Calendar cldr = Calendar.getInstance();
              int month = cldr.get(Calendar.MONTH);
              int day = cldr.get(Calendar.DAY_OF_MONTH);
              int year = cldr.get(1);
              DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                      tvDOB.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                  }
              },year,month,day);
              datePickerDialog.show();
          }
      });
                btn = findViewById(R.id.btnRegister);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      validate();

                    }
                });
btnShow=findViewById(R.id.btnShowRec);
btnShow.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String user = etUn.getText().toString();
        Cursor result=dbHelper.showDetails(user);
        if(result.getCount()!=0)
        {
            result.moveToNext();
            etPwd.setText(result.getString(1));
            etEmail.setText(result.getString(2));
            etPhone.setText(result.getString(3));
            tvDOB.setText(result.getString(4));
        }
        else {
            Toast.makeText(MainActivity.this,"No Record Found!!!",Toast.LENGTH_SHORT).show();
        }
    }
});

    btnUpdate=findViewById(R.id.btnUpdateRec);
    btnUpdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String user = etUn.getText().toString();
            String pwd = etPwd.getText().toString();
            String email = etEmail.getText().toString();
            String phone = etPhone.getText().toString();
            String dob = tvDOB.getText().toString();
           boolean result= dbHelper.updateRecord(user, pwd, email, phone,dob);
           if(result)
               Toast.makeText(MainActivity.this, "Record is updated", Toast.LENGTH_SHORT).show();
            else
               Toast.makeText(MainActivity.this, "Some error in updation", Toast.LENGTH_SHORT).show();
        }
    });
    btnDelete=findViewById(R.id.btnDeleteRec);
    btnDelete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String user = etUn.getText().toString();
            boolean result=dbHelper.deleteRecord(user);
            if(result)
                Toast.makeText(MainActivity.this, "Record deleted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Some error in deletion", Toast.LENGTH_SHORT).show();
        }
   });   }

            void validate() {
                String user = etUn.getText().toString();
                String pwd = etPwd.getText().toString();
                String cpwd = etCPwd.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();
                String dob = tvDOB.getText().toString();

                if (user.isEmpty()) {
                    etUn.setError("Username cannot be empty!");
                    etUn.requestFocus();
                    return;
                }
                if (pwd.isEmpty()) {
                    etPwd.setError("Password cannot be empty!");
                    etPwd.requestFocus();
                    return;
                }
                if (cpwd.isEmpty()) {
                    etCPwd.setError("Confirm password should match!");
                    etCPwd.requestFocus();
                    return ;

                }
                if (!pwd.equalsIgnoreCase(cpwd)) {
                    Toast.makeText(MainActivity.this, "Both passwords should match !!", Toast.LENGTH_SHORT).show();
                    etCPwd.requestFocus();
                    return ;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Enter proper email!");
                    etEmail.requestFocus();
                    return ;
                }
                if (!Patterns.PHONE.matcher(phone).matches()) {
                    etPhone.setError("Enter valid phone number!");
                    etPhone.requestFocus();
                    return;
                }

             boolean result=   dbHelper.addRecord(user,pwd,email,phone,dob);
                if(result)
                {
                    Toast.makeText(this, "Record added", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this, "Some error", Toast.LENGTH_SHORT).show();
            }

        }

