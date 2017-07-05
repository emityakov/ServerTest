package com.example.student1.servertest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by student1 on 05.07.17.
 */
public interface MessageRequest {
    @GET("/json.php")
    Call<Messages> getPersons();

    @GET("/json.php")
    Call<Message> getPersonById(@Query("id") int id);
}
