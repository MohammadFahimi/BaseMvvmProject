package com.mohammadfahimi.basemvvmproject.Data.local;

import android.arch.lifecycle.LiveData;

import com.mohammadfahimi.basemvvmproject.Data.local.Entity.User;

import java.util.List;

public interface DbHelper {

    public void saveToken(String token);

    public  void insertUser(User user);

    public LiveData<List<User>> getAllUsers();

}
