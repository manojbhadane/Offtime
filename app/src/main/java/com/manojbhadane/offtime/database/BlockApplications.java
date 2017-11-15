package com.manojbhadane.offtime.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by manoj.bhadane on 15-11-2017.
 */
@Entity
public class BlockApplications
{
    @PrimaryKey(autoGenerate = true)
    private int BlockApplicationsId;

    @ColumnInfo(name = "uid")
    private int uid;

    @ColumnInfo(name = "pkgName")
    private String pkgName;

    public int getBlockApplicationsId()
    {
        return BlockApplicationsId;
    }

    public void setBlockApplicationsId(int blockApplicationsId)
    {
        BlockApplicationsId = blockApplicationsId;
    }

    public int getUid()
    {
        return uid;
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

    public String getPkgName()
    {
        return pkgName;
    }

    public void setPkgName(String pkgName)
    {
        this.pkgName = pkgName;
    }
}
