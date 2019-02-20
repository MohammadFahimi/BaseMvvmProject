package com.mohammadfahimi.basemvvmproject.Data.Remote;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper(ApiService apiService) {
    }
}
