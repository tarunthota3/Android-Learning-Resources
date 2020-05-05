package com.example.module7_part2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EmailAdapter extends ArrayAdapter<Email> {
    public EmailAdapter(@NonNull Context context, int resource, @NonNull List<Email> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Email email = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.email_item, parent,false);
            viewHolder = new ViewHolder();
            viewHolder.textViewSubject = convertView.findViewById(R.id.textViewSubject);
            viewHolder.textViewSummary = convertView.findViewById(R.id.textViewSummary);
            viewHolder.textViewEmail = convertView.findViewById(R.id.textViewEmail);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.textViewSubject.setText(email.subject);
        viewHolder.textViewSummary.setText(email.summary);
        viewHolder.textViewEmail.setText(email.sender);

        return convertView;
    }
    private static class ViewHolder{
        TextView textViewSubject;
        TextView textViewSummary;
        TextView textViewEmail;
    }
}
