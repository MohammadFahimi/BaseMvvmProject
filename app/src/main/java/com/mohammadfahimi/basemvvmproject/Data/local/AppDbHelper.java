package com.mohammadfahimi.basemvvmproject.Data.local;

import android.arch.lifecycle.LiveData;

import com.mohammadfahimi.basemvvmproject.Data.local.Entity.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class AppDbHelper implements DbHelper {

    private AppDatabase database;

    @Inject
    public AppDbHelper(AppDatabase database) {
        this.database = database;
    }

    @Override
    public void saveToken(String token) {
        database.userDao();
    }

    @Override
    public void insertUser(User user) {
        Completable.fromAction(() -> {
            database.userDao().insertUser(user);
        }).subscribeOn(Schedulers.io())
        .subscribe();


    }

    @Override
    public LiveData<List<User>> getAllUsers() {
        return database.userDao().getUsersList();
    }
}
