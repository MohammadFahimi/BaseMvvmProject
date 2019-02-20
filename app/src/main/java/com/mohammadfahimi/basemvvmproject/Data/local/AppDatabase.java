package com.mohammadfahimi.basemvvmproject.Data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mohammadfahimi.basemvvmproject.Data.local.Dao.UserDao;
import com.mohammadfahimi.basemvvmproject.Data.local.Entity.User;


@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}