package com.mohammadfahimi.basemvvmproject.Data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.util.Log;
import android.widget.Toast;

import com.mohammadfahimi.basemvvmproject.Data.Remote.ApiService;
import com.mohammadfahimi.basemvvmproject.Data.SharedPref.PreferencesHelper;
import com.mohammadfahimi.basemvvmproject.Data.local.DbHelper;
import com.mohammadfahimi.basemvvmproject.Data.local.Entity.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {
    ApiService apiService;
    PreferencesHelper preferencesHelper;
    Application application;
    DbHelper dbHelper;

    @Inject
    public AppDataManager(Application application, ApiService apiService,
                          PreferencesHelper preferencesHelper, DbHelper dbHelper) {
        this.apiService = apiService;
        this.preferencesHelper = preferencesHelper;
        this.application = application;
        this.dbHelper = dbHelper;
    }

    @Override
    public void saveToken(String token) {
        dbHelper.saveToken(token);
    }

    @Override
    public void insertUser(User user) {
        dbHelper.insertUser(user);
    }

    @Override
    public LiveData<List<User>> getAllUsers() {
        return dbHelper.getAllUsers();
    }
}
