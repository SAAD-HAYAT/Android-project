package com.saad.androidproject.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.saad.androidproject.dao.UserDao;
import com.saad.androidproject.entity.UserEntity;

    @Database(entities = {UserEntity.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract UserDao userDao();

    }


