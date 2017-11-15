package com.manojbhadane.offtime;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.manojbhadane.offtime.database.DBHelper;

/**
 * Created by manoj.bhadane on 15-11-2017.
 */
public class App extends Application
{
    public static App INSTANCE;
    public DBHelper dbHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        INSTANCE = this;
        dbHelper = Room.databaseBuilder(getApplicationContext(), DBHelper.class, Constant.DATABASE_NAME).build();
    }

    public static App get()
    {
        return INSTANCE;
    }

    public DBHelper getDBInstance()
    {
        return dbHelper;
    }
}
