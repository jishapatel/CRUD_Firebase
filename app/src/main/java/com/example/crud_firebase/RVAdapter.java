package com.example.crud_firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<Students> list = new ArrayList<>();
    public RVAdapter(Context ctx){
        this.context = ctx;
    }
    public void setItems(ArrayList<Students> stu){
        list.addAll(stu);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new StudentVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StudentVH vh = (StudentVH) holder;
        Students stu = list.get(position);
        vh.name.setText(stu.getName());
        vh.course.setText(stu.getCourse());
        vh.sem.setText(stu.getSem());
        vh.ins.setText(stu.getIns());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
