package com.mohammadfahimi.basemvvmproject.UI.Main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mohammadfahimi.basemvvmproject.Data.local.Entity.User;
import com.mohammadfahimi.basemvvmproject.R;
import com.mohammadfahimi.basemvvmproject.UI.Base.BaseActivity;

import java.util.Date;
import java.util.Random;

public class MainActivity extends BaseActivity {
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
    }

}
