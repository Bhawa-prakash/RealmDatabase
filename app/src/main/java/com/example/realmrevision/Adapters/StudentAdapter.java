package com.example.realmrevision.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.realmrevision.Employee;
import com.example.realmrevision.R;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private static final String TAG = "AlertToneAdapter";
    private Context context;
    private List<Employee> studentList;

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView age;
        TextView email;
        TextView mobile;
        TextView address;
        TextView fathername;


        StudentViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.Name);
            age = view.findViewById(R.id.Age);
            email = view.findViewById(R.id.Email);
            mobile = view.findViewById(R.id.Mobileno);
            address = view.findViewById(R.id.Address);
            fathername = view.findViewById(R.id.Fathername);

        }
    }


    public StudentAdapter(Context context, List<Employee> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int position) {
        View view = null;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview, viewGroup, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder holder, int position) {


        holder.fathername.setText(studentList.get(position).getFatherName());
        holder.name.setText(studentList.get(position).getName());
        holder.age.setText(studentList.get(position).getAge());
        holder.email.setText(studentList.get(position).getEmail());
        holder.mobile.setText(studentList.get(position).getMobile());
        holder.address.setText(studentList.get(position).getAddress());
        holder.fathername.setText(studentList.get(position).getFatherName());


    }

    @Override
    public int getItemCount() {
        if (studentList != null)
            return studentList.size();


        return 0;


    }



}
