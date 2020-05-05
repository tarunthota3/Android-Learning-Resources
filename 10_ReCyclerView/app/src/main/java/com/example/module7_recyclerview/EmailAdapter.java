package com.example.module7_recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder>{
    ArrayList<Email> mData;

    public EmailAdapter(ArrayList<Email> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.email_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Email email = mData.get(position);
        holder.textViewSubject.setText(email.subject);
        holder.textViewSummary.setText(email.summary);
        holder.textViewEmail.setText(email.sender);
        holder.email = email;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "demo";
        // each data item is just a string in this case
        TextView textViewSubject;
        TextView textViewSummary;
        TextView textViewEmail;
        Email email;

        public ViewHolder(View v) {
            super(v);
            textViewSubject = v.findViewById(R.id.textViewSubject);
            textViewSummary = v.findViewById(R.id.textViewSummary);
            textViewEmail = v.findViewById(R.id.textViewEmail);
            this.email = email;

            v.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Button Clicked: " + email.sender);
                }
            });

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Clicked Email: " + email.sender);
                }
            });
        }
    }
}
