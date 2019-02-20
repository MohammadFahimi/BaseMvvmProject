package com.mohammadfahimi.basemvvmproject.DI.Module;

import com.mohammadfahimi.basemvvmproject.DI.scopes.ActivityScoped;
import com.mohammadfahimi.basemvvmproject.UI.Main.MainActivity;
import com.mohammadfahimi.basemvvmproject.UI.Main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();

}
