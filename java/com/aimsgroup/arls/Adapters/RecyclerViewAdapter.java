package com.aimsgroup.arls.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aimsgroup.arls.Models.RecyclerViewModelClass;
import com.aimsgroup.arls.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context  context;
    ArrayList<RecyclerViewModelClass> recyclerViewModelClasses;

    public RecyclerViewAdapter(Context context, ArrayList<RecyclerViewModelClass> recyclerViewModelClasses){
        this.context = context;
        this.recyclerViewModelClasses = recyclerViewModelClasses;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row, parent,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.getUserFullName.setText(recyclerViewModelClasses.get(position).getFullName());
        holder.getUserFirstWordName.setText(recyclerViewModelClasses.get(position).getFirstWordName());
        holder.getUserShortcutName.setText(recyclerViewModelClasses.get(position).getShortcutName());
        holder.getUserImageView.setImageResource(recyclerViewModelClasses.get(position).getImage());

    }



    @Override
    public int getItemCount() {
        return recyclerViewModelClasses.size();
    }



    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView getUserImageView;
        TextView getUserFullName, getUserFirstWordName, getUserShortcutName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemView.setBackgroundColor(Color.blue(1));
                    Log.d("RecyclerViewItemClicked", "onClick: Item Number "+ getUserFirstWordName.getText().toString() + " "+getUserShortcutName.getText().toString());
                }
            });
            getUserImageView = itemView.findViewById(R.id.imageView);
            getUserFullName  = itemView.findViewById(R.id.textView);
            getUserFirstWordName = itemView.findViewById(R.id.textView2);
            getUserShortcutName = itemView.findViewById(R.id.textView3);



        }
    }
}
