package com.example.realmrevision.Activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.realmrevision.Adapters.StudentAdapter;
import com.example.realmrevision.Model.Employee;
import com.example.realmrevision.R;

import java.util.List;


public class ShowData extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardView cardView;

    List<Employee> studentList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        recyclerView = findViewById(R.id.recycler);
        /* cardView = findViewById(R.id.cardview1);*/


        studentList = Employee.getAllStudents();


        if (studentList != null && studentList.size() > 0) {
            //TODO
            //Add recyclerView
            StudentAdapter studentAdapter = new StudentAdapter(this, studentList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(studentAdapter);
            recyclerView.setVisibility(View.VISIBLE);


        } else {

            recyclerView.setVisibility(View.GONE);
        }

          /*      cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(ShowData.this,UpdateActivity.class);
                    startActivity(i);
                }
            });

            */
    }

}

