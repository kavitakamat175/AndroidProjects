package com.example.firebasedemoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText txtId, txtName, txtAdd, txtphno;

    DatabaseReference dbref;
    Employee emp;
    String id, name, add, phno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtId = findViewById(R.id.empId);
        txtName = findViewById(R.id.empName);
        txtAdd = findViewById(R.id.empAdd);
        txtphno = findViewById(R.id.empPhno);

        emp = new Employee();
    }

    public void save(View view) {

        id = txtId.getText().toString();
        name = txtName.getText().toString();
        add = txtAdd.getText().toString();
        phno = txtphno.getText().toString();


        //Code to Save the employee details
        dbref = FirebaseDatabase.getInstance().getReference().child("Employee");
        try {
            if (TextUtils.isEmpty(txtId.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter ID",
                        Toast.LENGTH_LONG).show();
            else if (TextUtils.isEmpty(txtName.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter Name",
                        Toast.LENGTH_LONG).show();
            else if (TextUtils.isEmpty(txtphno.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter Phone Number",
                        Toast.LENGTH_LONG).show();
            else {
                emp.setID(id);
                emp.setName(name);
                emp.setAddress(add);
                emp.setPhno(phno);

                //insert details in db.
                dbref.child(id).setValue(emp);
                Toast.makeText(getApplicationContext(), "Record Added",
                        Toast.LENGTH_LONG).show();

                txtId.setText("");
                txtName.setText("");
                txtAdd.setText("");
                txtphno.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Code to Display a Record
    public void show(View view) {

        id = txtId.getText().toString();

        dbref = FirebaseDatabase.getInstance().getReference().child("Employee").child(id);

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    txtId.setEnabled(false);
                    txtName.setText(snapshot.child("name").getValue().toString());
                    txtAdd.setText(snapshot.child("address").getValue().toString());
                    txtphno.setText(snapshot.child("phno").getValue().toString());
                } else {
                    Toast.makeText(getApplicationContext(), "No data to display",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //Code to update a Record
    public void update(View view) {

        id = txtId.getText().toString();

        dbref = FirebaseDatabase.getInstance().getReference().child("Employee").child(id);

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    emp.setName(txtName.getText().toString().trim());
                    emp.setAddress(txtAdd.getText().toString().trim());
                    emp.setPhno(txtphno.getText().toString().trim());

                    dbref.setValue(emp);
                    Toast.makeText(getApplicationContext(), "Data Updated",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No data to update",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    //Code to delete a Record
    public void delete(View view) {
        id = txtId.getText().toString();
        dbref = FirebaseDatabase.getInstance().getReference().child("Employee").child(id);

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    dbref.removeValue();
                    Toast.makeText(getApplicationContext(), "Record Deleted",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No such record",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
