package com.example.realmrevision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import io.realm.Realm;
import io.realm.RealmResults;

public class UpdateActivity extends AppCompatActivity {
    EditText nam;
    EditText ag;
    EditText ema;
    EditText mob;
    EditText addr;
    EditText father;
    Button updatebtn, deletebtn;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        deletebtn = findViewById(R.id.debtn);
        updatebtn = findViewById(R.id.updatebtn);
        nam = findViewById(R.id.name1);
        ag = findViewById(R.id.age2);
        ema = findViewById(R.id.email3);
        mob = findViewById(R.id.phoneno4);
        addr = findViewById(R.id.Address5);
        father = findViewById(R.id.FatherName6);

        //fetching data from adapter class in this activity
        Bundle bundle = getIntent().getExtras();
        String namee = bundle.getString("NAME");
        String agee = bundle.getString("AGE");
        String emaill = bundle.getString("EMAIL");
        String mobilee = bundle.getString("MOBILE");
        String addresss = bundle.getString("ADDRESS");
        String fatherr = bundle.getString("FATHER");


        nam.setText(namee);
        ag.setText(agee);
        ema.setText(emaill);
        mob.setText(mobilee);
        addr.setText(addresss);
        father.setText(fatherr);


        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteEmployeeRecord();
            }
        });
    }

    private void deleteEmployeeRecord() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Employee> employee = realm.where(Employee.class).equalTo("NAME", Employee.getAllStudents().toString().trim()).findAll();
                employee.deleteAllFromRealm();
            }
        });
    }

}

