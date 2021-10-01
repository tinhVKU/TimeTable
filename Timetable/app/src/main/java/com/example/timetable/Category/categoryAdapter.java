package com.example.timetable.Category;

import android.content.Context;
import android.icu.util.ULocale;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.timetable.R;

import java.util.List;

public class categoryAdapter extends ArrayAdapter<categoryObject> {

    public categoryAdapter(@NonNull Context context, int resource, @NonNull List<categoryObject> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_selected,parent,false);
        TextView tvSelected = convertView.findViewById(R.id.tv_selected);
        categoryObject category = this.getItem(position);
        if (category != null){
            tvSelected.setText(category.getName());
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        TextView tvCategory = convertView.findViewById(R.id.tv_category);
        categoryObject category = this.getItem(position);
        if (category != null){
            tvCategory.setText(category.getName());
        }

        return convertView;
    }
}
