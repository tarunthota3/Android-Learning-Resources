package com.example.recyclerviewexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public static InteractWithMainActivity interact;
    Context ctx;

    ArrayList<User> users = new ArrayList<User>();
    static String TAG = "demo";

    public MyAdapter(ArrayList<User> users, Context mainActivity) {
        this.users = users;
        this.ctx = mainActivity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout rv_layout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(rv_layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        interact = (InteractWithMainActivity) ctx;
        holder.tv_name.setText(users.get(position).getName());
        holder.tv_email.setText(users.get(position).getEmail());
        holder.tv_address.setText(users.get(position).getAddress());
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Delete clicked from: "+users.get(position).getName());
                interact.deleteItem(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_email, tv_address;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_email = itemView.findViewById(R.id.tv_email);
            tv_address = itemView.findViewById(R.id.tv_address);
            button_delete = itemView.findViewById(R.id.button_delete);
        }
    }

    public interface InteractWithMainActivity{
        void deleteItem(int position);
    }
}
