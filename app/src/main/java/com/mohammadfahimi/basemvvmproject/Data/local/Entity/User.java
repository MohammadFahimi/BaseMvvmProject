package com.mohammadfahimi.basemvvmproject.Data.local.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.mohammadfahimi.basemvvmproject.Data.local.RoomConverter.DateConverter;

import java.util.Date;

import lombok.Data;

@Entity(tableName = "user")
@Data
@TypeConverters(DateConverter.class)
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long _id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "family")
    private String family;

    @ColumnInfo(name = "insert_date")
    private Date insertData;
}
