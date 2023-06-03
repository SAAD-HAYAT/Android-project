package com.saad.androidproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.saad.androidproject.entity.UserEntity;

import java.util.List;
@Dao
public interface UserDao {

        @Query("Select * from UserEntity")
        List<UserEntity> getAll();

        @Insert
        void insertUser(UserEntity userEntity);

        @Delete
        void deleteUser(UserEntity userEntity);
    }

