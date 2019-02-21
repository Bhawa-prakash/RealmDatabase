package com.example.realmrevision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javax.annotation.Nullable;

import io.realm.Realm;

public class AddData extends AppCompatActivity {
    EditText name;
    EditText age;
    EditText email;
    EditText mobile;
    EditText address;
    EditText fatherName;
    Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.phoneno);
        address = findViewById(R.id.Address);
        fatherName = findViewById(R.id.FatherName);

        //realm object created
        realm = Realm.getDefaultInstance();

        findViewById(R.id.addbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //open the database
                realm.beginTransaction();


                //inserted all data to database
                Employee obj = realm.createObject(Employee.class);
                obj.setName(name.getText().toString().trim());
                obj.setAge(age.getText().toString().trim());
                obj.setEmail(email.getText().toString().trim());
                obj.setMobile(mobile.getText().toString().trim());
                obj.setAddress(address.getText().toString().trim());
                obj.setFatherName(fatherName.getText().toString().trim());
                //close the database
                realm.commitTransaction();

                finish();

            }
        });


    }
}
