package com.example.whf_shop.application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class WHFShopApplication extends Application {
    private static WHFShopApplication instance;
    private static Context appContext;

    public static WHFShopApplication getInstance(){
        return instance;
    }

    public static Context getAppContext() { return appContext;}

    public void setAppContext(Context mAppContext) {this.appContext = mAppContext;}

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
