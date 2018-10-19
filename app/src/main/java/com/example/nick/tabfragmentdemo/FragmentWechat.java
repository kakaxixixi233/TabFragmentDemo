package com.example.nick.tabfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class FragmentWechat extends Fragment {

   private  ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragmentwechat,null);
         lv= (ListView) v.findViewById(R.id.listview);

        List<Person> list = new ArrayList<Person>();
        Person p1= new Person(getResources().getDrawable(R.mipmap.ic_launcher),"1","1");
        Person p2= new Person(getResources().getDrawable(R.mipmap.ic_launcher),"2","2");
        Person p3= new Person(getResources().getDrawable(R.mipmap.ic_launcher),"3","4");
        Person p4= new Person(getResources().getDrawable(R.mipmap.ic_launcher),"5","5");


        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);


        ListAdapter listAdapter = new ListAdapter(FragmentWechat.super.getActivity(),list);
        lv.setAdapter(listAdapter);
        return v;

    }
}
