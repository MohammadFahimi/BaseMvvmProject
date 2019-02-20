package com.mohammadfahimi.basemvvmproject.UI.Base;

import android.arch.lifecycle.ViewModel;

import com.mohammadfahimi.basemvvmproject.Data.DataManager;

import javax.inject.Inject;

public class BaseViewModel extends ViewModel {
    private DataManager dataManager;

    @Inject
    public BaseViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
