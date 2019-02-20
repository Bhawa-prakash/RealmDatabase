package com.example.realmrevision;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.realmrevision.Adapters.StudentAdapter;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ShowData extends AppCompatActivity {
    private RecyclerView recyclerView;

    List<Employee> studentList;


        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_data);
            recyclerView = findViewById(R.id.recycler);

               studentList=Employee.getAllStudents();


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


        }





        }

