package com.tuacy.room.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.tuacy.room.database.entities.MiniProgram;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MiniDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insert(MiniProgram... miniPrograms);

    @Query("select * from mini_program")
    Flowable<List<MiniProgram>> query();

    @Delete
    int delete(MiniProgram... miniPrograms);

    @Update
    int update(MiniProgram... miniPrograms);
}
