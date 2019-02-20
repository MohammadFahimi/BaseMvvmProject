package com.mohammadfahimi.basemvvmproject.DI.Component;

import android.app.Application;

import com.mohammadfahimi.basemvvmproject.App.App;
import com.mohammadfahimi.basemvvmproject.DI.Module.ActivityBindingModule;
import com.mohammadfahimi.basemvvmproject.DI.Module.AppModule;
import com.mohammadfahimi.basemvvmproject.DI.Module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ViewModelModule.class,
        AppModule.class,
        ActivityBindingModule.class
})
public interface AppComponent extends AndroidInjector<App> {
    @Override
    void inject(App application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
