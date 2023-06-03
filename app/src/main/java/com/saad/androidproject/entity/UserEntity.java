package com.saad.androidproject.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserEntity {
    public UserEntity(int uId, String userName, String userEmail, String userPassword){
        this.uId = uId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    @PrimaryKey
    public int uId;
    @ColumnInfo(name="user_name")
    public String userName;
    @ColumnInfo(name="user_email")
    public String userEmail;
    @ColumnInfo(name="user_password")
    public String userPassword;
}
