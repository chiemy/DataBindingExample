package com.chiemy.example.databindingexample;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewStubProxy;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.View;

import com.chiemy.example.databindingexample.bean.User;
import com.chiemy.example.databindingexample.databinding.ListItemBinding;
import com.chiemy.example.databindingexample.databinding.ViewStubBinding;

public class ViewStubActivity extends AppCompatActivity {
    private ViewStubProxy viewStubProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewStubBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
        // viewStubProxy = binding.viewStub;
        // viewStubProxy = new ViewStubProxy(binding.viewStub); // 这种方式编译报转型错误(ViewStubProxy无法转换为ViewStub)??
        viewStubProxy = new ViewStubProxy((ViewStub) findViewById(R.id.viewStub));

        viewStubProxy.setContainingBinding(binding);
        viewStubProxy.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                ListItemBinding binding = (ListItemBinding) viewStubProxy.getBinding();
                User user = new User();
                user.setFirstName("chiemy");
                binding.setUser(user);
            }
        });


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!viewStubProxy.isInflated()) {
                    viewStubProxy.getViewStub().inflate();
                }
            }
        });
    }
}
