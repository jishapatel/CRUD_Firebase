package com.example.crud_firebase;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentVH extends RecyclerView.ViewHolder {
    public TextView name,course,sem,ins;
    public StudentVH(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tvname);
        course = itemView.findViewById(R.id.tvcourse);
        sem = itemView.findViewById(R.id.tvsem);
        ins = itemView.findViewById(R.id.tvins);
    }
}