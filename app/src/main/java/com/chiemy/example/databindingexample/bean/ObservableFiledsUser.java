package com.chiemy.example.databindingexample.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by hotbody on 16/5/16.
 */
public class ObservableFiledsUser {
    private ObservableField<String> name = new ObservableField<String>();
    private ObservableInt age = new ObservableInt();
    private ObservableBoolean isFriend = new ObservableBoolean();;

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public void setIsFriend(boolean isFriend){
        this.isFriend.set(isFriend);
    }

    public ObservableInt getAge() {
        return age;
    }
}
