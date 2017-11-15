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
public interface ProfileDao
{
    @Query("SELECT * FROM profile")
    List<Profile> getAllProfiles();

//    @Query("SELECT * FROM profile WHERE uid = uid")
//    Profile findById(int uid);

    @Insert
    void insertAll(List<Profile> profile);

    @Update
    void update(Profile profile);

    @Delete
    void delete(Profile profile);
}
