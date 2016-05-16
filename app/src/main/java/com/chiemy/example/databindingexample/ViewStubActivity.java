package com.chiemy.example.databindingexample;

import android.databinding.DataBindingUtil;
import android.databinding.ViewStubProxy;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.view.View;

public class ViewStubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);

        ViewStubActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
        final ViewStubProxy viewStubProxy = new ViewStubProxy(binding.viewStub);
        viewStubProxy.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                InflatedLayoutBinding layoutBinding = (InflatedLayoutBinding)viewStubProxy.getBinding();
                // TODO 为InflatedLayoutBinding设置数据
            }
        });
        ...

        // 必要时，填充进来
        if(!viewStubProxy.isInflated()){
            viewStubProxy.getViewStub().inflate();
        }
    }
}
