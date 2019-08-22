package com.example.mathgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewContent extends ArrayAdapter {

    private TextView level_name;
    private ImageView image_level;

    ListViewContent(Context context, ArrayList<ContentOfList> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_levels, parent, false);
        }

        //define TextView and ImageView
        level_name = (TextView) convertView.findViewById(R.id.text);
        image_level = (ImageView) convertView.findViewById(R.id.image);

        //get content of ech ArrayList item
        ContentOfList contentOfList = (ContentOfList) getItem(position);

        //set Content to Views
        level_name.setText(contentOfList.getLevel());
        level_name.setTextColor(contentOfList.getColor());
        image_level.setImageResource(contentOfList.getImage());

        return convertView;
    }
}
