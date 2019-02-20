package com.mohammadfahimi.basemvvmproject.DI.Module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.mohammadfahimi.basemvvmproject.BuildConfig;
import com.mohammadfahimi.basemvvmproject.DI.Qualifier.ApplicationContext;
import com.mohammadfahimi.basemvvmproject.DI.Qualifier.DatabaseInfo;
import com.mohammadfahimi.basemvvmproject.Data.AppDataManager;
import com.mohammadfahimi.basemvvmproject.Data.DataManager;
import com.mohammadfahimi.basemvvmproject.Data.Remote.ApiHelper;
import com.mohammadfahimi.basemvvmproject.Data.Remote.ApiService;
import com.mohammadfahimi.basemvvmproject.Data.Remote.AppApiHelper;
import com.mohammadfahimi.basemvvmproject.Data.SharedPref.AppPreferencesHelper;
import com.mohammadfahimi.basemvvmproject.Data.SharedPref.PreferencesHelper;
import com.mohammadfahimi.basemvvmproject.Data.local.AppDatabase;
import com.mohammadfahimi.basemvvmproject.Data.local.AppDbHelper;
import com.mohammadfahimi.basemvvmproject.Data.local.DbHelper;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class AppModule {
    @Binds
    @Singleton
    @ApplicationContext
    abstract Context provideApplicationContext(Application application);

    @Binds
    @Singleton
    abstract DbHelper provideDbHelper(AppDbHelper appDbHelper);

    @Binds
    @Singleton
    abstract ApiHelper provideApiHelper(AppApiHelper appApiHelper);

    @Binds
    @Singleton
    abstract DataManager provideDataManager(AppDataManager dataManager);

    @Binds
    @Singleton
    abstract PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper);

    @Provides
    @Singleton
    static AppDatabase provideAppDatabase(@DatabaseInfo String dbName, @ApplicationContext Context context) {
        return Room
                .databaseBuilder(context, AppDatabase.class, dbName)
//                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @DatabaseInfo
    @Singleton
    static String provideDatabaseInfo() {
        return "appDb";
    }

    @Provides
    @Named("BASE_URL")
    @Singleton
    static String provideBseUrl() {
        return "https://api.example.com/";
    }

    @Provides
    @Singleton
    static OkHttpClient.Builder provideOkHttpClient(@ApplicationContext final Context context) {

        File cacheFile = new File(context.getCacheDir(), "httpCache");
        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .cache(cache)
                .build();

        if (BuildConfig.DEBUG)
            httpClient.addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY));

        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("version", String.valueOf(BuildConfig.VERSION_CODE))
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        return httpClient;

    }


    @Provides
    @Singleton
    static Retrofit provideRetrofit(OkHttpClient.Builder httpClient, @Named("BASE_URL") String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    static ApiService provideAPI(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
