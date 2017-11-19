package com.muxistudio.oneday;

import android.app.Application;
import android.content.Context;

import com.muxistudio.oneday.db.DaoMaster;
import com.muxistudio.oneday.db.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by fengminchao on 17/11/18
 */

public class App extends Application{

    private static DaoSession sDaoSession;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this,"diary.db");
        Database db = devOpenHelper.getWritableDb();
        sDaoSession = new DaoMaster(db).newSession();

    }

    public static Context getContext() {
        return sContext;
    }

    public static DaoSession getDaoSession(){
        return sDaoSession;
    }
}
