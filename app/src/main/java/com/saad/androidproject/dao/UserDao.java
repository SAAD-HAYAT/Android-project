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
        @Query("Select COUNT(*) from UserEntity")
        int getUserCount();
        @Query("Select * from UserEntity where user_name LIKE :name")
        UserEntity findByName(String name);
        @Insert
        void insertUser(UserEntity userEntity);

        @Delete
        void deleteUser(UserEntity userEntity);
    }

