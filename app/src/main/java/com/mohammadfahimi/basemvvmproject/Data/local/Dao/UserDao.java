package com.mohammadfahimi.basemvvmproject.Data.local.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mohammadfahimi.basemvvmproject.Data.local.Entity.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    //liveData runs query on background
    @Query("SELECT * FROM user ORDER BY insert_date")
    LiveData<List<User>> getUsersList();

    //if you are using room 2.1.0 or higher

//    @Query("SELECT * FROM user WHERE _id=:id")
//    Maybe<User> getUserById(long id);


//    @Insert
//    Completable insert(User user);
//    // or
//    @Insert
//    Maybe<Long> insert(User user);
//    // or
//    @Insert
//    Single<Long> insert(User[] user);
//    // or
//    @Insert
//    Maybe<List<Long>> insert(User[] user);
//    // or
//    @Insert
//    Single<List<Long>> insert(User[] user);

//    @Update
//    Completable update(User user);
//    // or
//    @Update
//    Single<Integer> update(User user);
//    // or
//    @Update
//    Single<List<Integer>> updateAll(User[] user);
//    // or
//    @Delete
//    Single<List<Integer>> deleteAll(User[] user);
//    // or
//    @Delete
//    Single<Integer> deleteAll(User[] user);
}
