package com.haoxueren.greendaoupgrade;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        // 1. 把旧数据迁移到一个临时表
        // 2. 把旧表删除
        // 3. 创建新表
        // 4. 把临时表的内容迁移到新表
        // 5. 删除临时表

        // 升级数据库
        MigrationHelper.migrate(db, PersonDao.class);

    }
}
