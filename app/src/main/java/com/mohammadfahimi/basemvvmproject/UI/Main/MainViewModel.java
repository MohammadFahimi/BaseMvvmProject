package com.mohammadfahimi.basemvvmproject.UI.Main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mohammadfahimi.basemvvmproject.Data.AppDataManager;
import com.mohammadfahimi.basemvvmproject.Data.DataManager;
import com.mohammadfahimi.basemvvmproject.Data.local.Entity.User;
import com.mohammadfahimi.basemvvmproject.UI.Base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {

    @Inject
    public MainViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public void insertUser(User user) {
        getDataManager().insertUser(user);
    }

    public LiveData<List<User>> getUsersList() {
        return getDataManager().getAllUsers();
    }
}
