package com.chiemy.example.databindingexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chiemy.example.databindingexample.bean.ObservableUser;
import com.chiemy.example.databindingexample.databinding.ActivityObservableBinding;

public class ObservableActivity extends AppCompatActivity {

    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Observable POJO");
        ActivityObservableBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
        final ObservableUser user = new ObservableUser();
        user.setName("chiemy");
        binding.setUser(user);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName("chiemy" + index++);
            }
        });
    }

}
