package com.manojbhadane.offtime.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.manojbhadane.offtime.Constant;

/**
 * Created by manoj.bhadane on 15-11-2017.
 */
@Database(entities = {Profile.class, BlockApplications.class}, version = Constant.DATABASE_VERSION)
public abstract class DBHelper extends RoomDatabase
{
    public abstract ProfileDao profileDao();

    public abstract BlockApplicationsDao blockApplicationsDao();
}
