package com.team.swastik.myapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyNameViewHolder> {

    private List<PersonInfo> mDataset ;

    public MyAdapter(List<PersonInfo> mDataset) {
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public MyNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name, parent, false);
        MyNameViewHolder vh = new MyNameViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyNameViewHolder holder, int position) {
        PersonInfo model = mDataset.get(position);
        holder.textViewName.setText(model.getName());
        if (model.isStatus()){
            holder.textViewStatus.setText("Online");
            holder.textViewStatus.setTextColor(Color.parseColor("#008577"));
        }else {
            holder.textViewStatus.setText("Offline");
            holder.textViewStatus.setTextColor(Color.parseColor("#e30909"));
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void addNameToDataset(PersonInfo personInfo){
        mDataset.add(personInfo);
       notifyDataSetChanged();
    }

    public static class MyNameViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewStatus;
        public MyNameViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewStatus = itemView.findViewById(R.id.textViewOnline);
        }
    }



}
