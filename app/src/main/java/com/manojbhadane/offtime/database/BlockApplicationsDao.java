package com.manojbhadane.offtime.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by manoj.bhadane on 15-11-2017.
 */
@Dao
public interface BlockApplicationsDao
{
    @Query("SELECT * FROM blockapplications")
    List<BlockApplications> getAllBlockApplication();

//    @Query("SELECT * FROM blockapplications WHERE uid=uid")
//    BlockApplications findById(int uid);

    @Insert
    void insertAll(List<BlockApplications> blockApplicationses);

    @Update
    void update(BlockApplications blockApplications);

    @Delete
    void delete(BlockApplications blockApplications);
}
