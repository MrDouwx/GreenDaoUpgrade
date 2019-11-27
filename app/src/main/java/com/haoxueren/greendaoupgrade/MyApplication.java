package com.haoxueren.greendaoupgrade;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class MyApplication extends Application {

    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始GreenDao
        daoSession = initGreenDao();
    }

    private DaoSession initGreenDao() {
        MyOpenHelper openHelper = new MyOpenHelper(this, "Person.db");
        SQLiteDatabase database = openHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        return daoMaster.newSession();
    }
}
