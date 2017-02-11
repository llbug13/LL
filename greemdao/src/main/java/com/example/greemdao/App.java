package com.example.greemdao;

import android.app.Application;
import android.content.Context;

import org.greenrobot.greendao.database.Database;

public class App extends Application {
    /**
     * A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher.
     */
    public static final boolean ENCRYPTED = false;

    private DaoSession daoSession;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplication();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static Context getApplication() {
        return context;
    }
}
