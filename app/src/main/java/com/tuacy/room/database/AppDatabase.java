package com.tuacy.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.tuacy.room.database.daos.BookDao;
import com.tuacy.room.database.daos.MiniDao;
import com.tuacy.room.database.daos.UserDao;
import com.tuacy.room.database.entities.Book;
import com.tuacy.room.database.entities.MiniProgram;
import com.tuacy.room.database.entities.User;

@Database(entities = {User.class, Book.class, MiniProgram.class}, version = 4)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

	public abstract UserDao userDao();

	public abstract BookDao bookDao();

	public abstract MiniDao miniDao();

}
