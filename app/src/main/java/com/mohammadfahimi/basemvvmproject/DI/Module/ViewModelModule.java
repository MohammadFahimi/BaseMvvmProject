package com.mohammadfahimi.basemvvmproject.DI.Module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.mohammadfahimi.basemvvmproject.DI.DaggerViewModelFactory;
import com.mohammadfahimi.basemvvmproject.DI.ViewModelKey;
import com.mohammadfahimi.basemvvmproject.UI.Main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DaggerViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel provideMainViewModel(MainViewModel mainVM);

}