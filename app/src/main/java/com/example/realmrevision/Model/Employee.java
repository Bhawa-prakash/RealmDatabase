package com.example.realmrevision.Model;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Employee extends RealmObject {


    @PrimaryKey
    String email;

    String name;
    String age;


    String mobile;
    String address;
    String fatherName;
    /* Realm realm;*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }

    public static List<Employee> getAllStudents() {
        try {
            Realm realm = Realm.getDefaultInstance();
            return realm.where(Employee.class).findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
