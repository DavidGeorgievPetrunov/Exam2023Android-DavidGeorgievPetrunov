package com.example.exam2023android_davidgeorgievpetrunov;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> names;

    private ArrayList<Integer> images;

    public MyAdapter(Context context, int layout, ArrayList<String> names, ArrayList<Integer> images) {
        this.context = context;
        this.layout = layout;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        View v = layoutInflater.inflate(R.layout.list_item, null);

        String currentName = names.get(position);
        Integer currentImage = images.get(position);

            TextView textView = (TextView) v.findViewById(R.id.textView5);
            textView.setText(currentName);

        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        imageView.setBackgroundResource(currentImage);
        return v;
    }
}
