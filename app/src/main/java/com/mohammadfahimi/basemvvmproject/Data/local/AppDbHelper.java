package com.mohammadfahimi.basemvvmproject.Data.local;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDbHelper implements DbHelper {

    private AppDatabase database;

    @Inject
    public AppDbHelper(AppDatabase database) {
        this.database = database;
    }

}
