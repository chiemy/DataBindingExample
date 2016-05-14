package com.chiemy.example.databindingexample.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.chiemy.example.databindingexample.BR;

/**
 * Created by chiemy on 16/5/14.
 */
public class ObservableUser extends BaseObservable{
    private String name;

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getName() {
        return name;
    }
}
