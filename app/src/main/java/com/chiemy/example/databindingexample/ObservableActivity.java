package com.chiemy.example.databindingexample;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.chiemy.example.databindingexample.bean.ObservableFiledsUser;
import com.chiemy.example.databindingexample.bean.ObservableUser;
import com.chiemy.example.databindingexample.databinding.ActivityObservableBinding;

public class ObservableActivity extends AppCompatActivity implements View.OnClickListener{
    private ObservableUser user;
    private ObservableFiledsUser filedsUser;
    private ObservableMap<String, Object> userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Observable Demo");
        ActivityObservableBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
        user = new ObservableUser();
        user.setName("chiemy");

        filedsUser = new ObservableFiledsUser();
        //filedsUser.setName("chiemy");
        filedsUser.setAge(10);

        binding.setFiledUser(filedsUser);
        binding.setUser(user);

        userInfo = new ObservableArrayMap<>();
        userInfo.put("firstName", "chiemy");
        binding.setMapUser(userInfo);


        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                user.setName("chiemy " + System.currentTimeMillis());
                break;
            case R.id.button1:
                int age = filedsUser.getAge().get();
                age++;
                filedsUser.setAge(age);
                break;
            case R.id.button2:
                userInfo.put("firstName", "chiemy " + System.currentTimeMillis());
                break;
        }
    }
}
