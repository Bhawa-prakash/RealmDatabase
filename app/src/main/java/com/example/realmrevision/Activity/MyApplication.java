package com.example.realmrevision.Activity;

import android.app.Application;

import com.example.realmrevision.BuildConfig;
import com.example.realmrevision.Model.LocalSyncModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override

    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());

        RealmConfiguration config =
                 new RealmConfiguration.Builder()
                        .deleteRealmIfMigrationNeeded()
                         .addModule(new LocalSyncModule())
                         .schemaVersion(BuildConfig.VERSION_CODE)
                        .build();

        Realm.setDefaultConfiguration(config);
    }

}
