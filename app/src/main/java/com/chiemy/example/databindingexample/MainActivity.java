package com.chiemy.example.databindingexample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chiemy.example.databindingexample.bean.User;
import com.chiemy.example.databindingexample.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // setContentView(R.layout.activity_main);
        // 官方文档说这种方式也可以,但是并没有用?
        // ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        // 这种方式是有效的
        // View root = getLayoutInflater().inflate(R.layout.activity_main, null);
        // setContentView(root);
        // ActivityMainBinding binding = ActivityMainBinding.bind(root);

        User user = new User();
        user.setFirstName("chiemy");
        user.setLastName("luo");

        binding.setUser(user);
        binding.setOnClicklistener(this);
        binding.setStyle(new Style());
    }

    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, ListItemBindingActivity.class);
        startActivity(intent);
    }
}
