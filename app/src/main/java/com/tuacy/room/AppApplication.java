package com.tuacy.room;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import com.tuacy.room.database.AppDatabase;

public class AppApplication extends Application {

    private AppDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "android_room_dev.db")
                .allowMainThreadQueries()
                .addMigrations(/*MIGRATION_1_2, MIGRATION_2_3, */MIGRATION_3_4, MIGRATION_5_4)
                .build();
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

    /**
     * 数据库版本 1->2 user表格新增了age列
     */
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE User ADD COLUMN age integer");
        }
    };

    /**
     * 数据库版本 2->3 新增book表格
     */
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `book` (`uid` INTEGER PRIMARY KEY autoincrement, `name` TEXT , `userId` INTEGER, 'time' INTEGER)");
        }
    };

    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(
                    "create table if not exists 'mini_program' ('id' INTEGER primary key autoincrement,'name' TEXT,'icon' TEXT,'desc' TEXT,'url' TEXT,'time' INTEGER) "
            );
        }
    };

    static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(
//                    "create table if not exists 'mini_program' ('id' INTEGER primary key,'name' TEXT,'icon' TEXT,'desc' TEXT,'url' TEXT,'time' INTEGER) "
                    "update 'mini_program' set name = '杨柳依依' "
            );
        }
    };

    static final Migration MIGRATION_5_4 = new Migration(5, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(
//                    "create table if not exists 'mini_program' ('id' INTEGER primary key,'name' TEXT,'icon' TEXT,'desc' TEXT,'url' TEXT,'time' INTEGER) "
                    "update 'mini_program' set name = '杨柳依依',icon = '192.168.0.11:9089','desc' = '详细描述得我文档' "
            );
        }
    };
}
