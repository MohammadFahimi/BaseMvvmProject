package com.mohammadfahimi.basemvvmproject.UI.Main;

import com.mohammadfahimi.basemvvmproject.Data.DataManager;
import com.mohammadfahimi.basemvvmproject.UI.Base.BaseViewModel;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {

    @Inject
    public MainViewModel(DataManager dataManager) {
        super(dataManager);
    }

}
