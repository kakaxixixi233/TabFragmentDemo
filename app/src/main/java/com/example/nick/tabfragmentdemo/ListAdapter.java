package com.example.nick.tabfragmentdemo;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    public List<Person> list= new ArrayList<Person>();
    public Context context;
    public LayoutInflater layoutInflater;

    public ListAdapter(FragmentActivity context, List<Person>list){
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = layoutInflater.inflate(R.layout.item, null);
        ImageView im = (ImageView) item.findViewById(R.id.imageView);
        TextView tv_name = (TextView) item.findViewById(R.id.textView2);
        TextView tv_age = (TextView) item.findViewById(R.id.textView);

        Person p = list.get(position);
        im.setImageDrawable(p.drawable);
        tv_name.setText(p.name);
        tv_age.setText(p.age);
        return item;
    }
}
