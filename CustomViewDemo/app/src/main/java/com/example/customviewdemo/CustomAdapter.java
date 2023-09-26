package com.example.customviewdemo;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    String[] fruitNames;
    int[] ids;
    LayoutInflater layoutInflater;

    CustomAdapter(Context context,String[] fruitNames, int[] ids)
    {
     this.fruitNames=fruitNames;
     this.ids=ids;
     layoutInflater=LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return fruitNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.custom_list,null);
        ImageView imageView=convertView.findViewById(R.id.imgFruit);
        imageView.setImageResource(ids[position]);
        TextView textView=convertView.findViewById(R.id.tvFruitName);
        textView.setText(fruitNames[position]);
        return convertView;

    }
}
