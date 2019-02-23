package com.example.realmrevision.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.realmrevision.Model.Employee;
import com.example.realmrevision.R;

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



        //Show on text view
        nam.setText(namee);
        ag.setText(agee);
        ema.setText(emaill);
        mob.setText(mobilee);
        addr.setText(addresss);
        father.setText(fatherr);


        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            try {
                Realm realm = Realm.getDefaultInstance();




                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            RealmResults<Employee> employees = realm.where(Employee.class).equalTo("email", emaill).findAll();
                            if (employees != null && employees.size() > 0) {
                                Employee employee = employees.first();
                                //  employee.setName();

                            }
                        }
                    });


            }catch (Exception e){
                e.printStackTrace();
            }


            }
        });



        //method to delete record
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteEmployeeRecord();
            }
        });
    }




    private void deleteEmployeeRecord() {

        Realm realm=Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                String username=nam.getText().toString().trim();

                RealmResults<Employee> employee = realm.where(Employee.class).equalTo("name",username).findAll();
                employee.deleteAllFromRealm();
                startActivity(new Intent(UpdateActivity.this,MainActivity.class));
                Toast.makeText(UpdateActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

