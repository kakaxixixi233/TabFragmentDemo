package com.example.nick.tabfragmentdemo;

import android.graphics.drawable.Drawable;

public class Person {
    public Drawable drawable;
    public String name;
    public String age;

    public Person(Drawable drawable, String age, String name) {
        this.drawable = drawable;
        this.age = age;
        this.name = name;
    }
}
