package com.saad.androidproject.retrofit;


//import retrofit2.Call;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
//import retrofit2.http.Query;

public interface APIInterface {

    @GET("/api/users?")
    Call<UserList> getUserList(@Query("page") String page);

    @POST("/api/users")
    Call<User> createUser(@Body User user);

}
