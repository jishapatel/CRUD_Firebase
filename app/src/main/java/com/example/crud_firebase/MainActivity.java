package com.example.crud_firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText name,course,sem,institute;
    Button insert,show,update,delete;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.etname);
        course = findViewById(R.id.etcourse);
        sem = findViewById(R.id.etsem);
        institute = findViewById(R.id.etinstiute);
        insert = findViewById(R.id.btnInsert);
        show = findViewById(R.id.btnShow);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);

        DAOstudents dao = new DAOstudents();
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students stu = new Students(name.getText().toString(),course.getText().toString(),sem.getText().toString(),institute.getText().toString());
                dao.add(stu).addOnSuccessListener(suc-> {
                    Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(err->{
                    Toast.makeText(MainActivity.this, "Data not Inserted"+err.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,Object> hashMap=new HashMap<>();
                hashMap.put("name",name.getText().toString());
                hashMap.put("course",course.getText().toString());
                hashMap.put("sem",sem.getText().toString());
                hashMap.put("ins",institute.getText().toString());
                dao.update("-M_ZSNG9mVt65L00_5p9",hashMap).addOnSuccessListener(suc-> {
                    Toast.makeText(MainActivity.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(err->{
                    Toast.makeText(MainActivity.this, "Data not Updated"+err.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete("-M_ZSNG9mVt65L00_5p9").addOnSuccessListener(suc-> {
                    Toast.makeText(MainActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(err->{
                    Toast.makeText(MainActivity.this, "Data not Deleted"+err.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(i);
            }
        });
    }
}