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

import com.aimsgroup.arls.Models.MyPendingBidsModelClass;
import com.aimsgroup.arls.R;

import java.util.ArrayList;

public class MyPendingBidsAdapter  extends RecyclerView.Adapter<MyPendingBidsAdapter.MyViewHolder>{

    Context context;
    ArrayList<MyPendingBidsModelClass> myPendingBidsModelClasses;

    public MyPendingBidsAdapter(Context context, ArrayList<MyPendingBidsModelClass> myPendingBidsModelClasses) {
        this.context = context;
        this.myPendingBidsModelClasses = myPendingBidsModelClasses;
    }



    @NonNull
    @Override
    public MyPendingBidsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_pending_bids_frame, parent,false);

        return new MyPendingBidsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPendingBidsAdapter.MyViewHolder holder, int position) {

        holder.getImageView.setImageResource(myPendingBidsModelClasses.get(position).getImage());
        holder.getName.setText(myPendingBidsModelClasses.get(position).getName());
        holder.getTime.setText(myPendingBidsModelClasses.get(position).getTime());
        holder.getRate.setText(myPendingBidsModelClasses.get(position).getRate());
        holder.getAdditional.setText(myPendingBidsModelClasses.get(position).getAdditional());
        holder.getButtonTag.setText(myPendingBidsModelClasses.get(position).getButtonTag());
    }

    @Override
    public int getItemCount() {
        return myPendingBidsModelClasses.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView getImageView;
        TextView getName, getTime, getRate, getAdditional, getButtonTag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(view -> {
                itemView.setBackgroundColor(Color.BLUE);
                Log.d("RecyclerViewItemClicked", "onClick: Item Number "+ getName.getText().toString() + " "+getTime.getText().toString());
            });
            getImageView = itemView.findViewById(R.id.image);
            getName  = itemView.findViewById(R.id.name);
            getTime = itemView.findViewById(R.id.time);
            getRate = itemView.findViewById(R.id.rate);
            getAdditional = itemView.findViewById(R.id.additional);
            getButtonTag =itemView.findViewById(R.id.deleteButton);



        }
    }
}
