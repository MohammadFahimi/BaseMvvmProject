package com.mohammadfahimi.basemvvmproject.Data.SharedPref;

import android.app.Application;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    @Inject
    public AppPreferencesHelper(Application application) {
    }
}
