package com.daud.retrogetpostidobject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("posts/{id}")
    Call<ModelClass> getData(@Query("id") int id);
}
