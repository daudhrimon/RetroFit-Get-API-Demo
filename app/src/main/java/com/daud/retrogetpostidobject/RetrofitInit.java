package com.daud.retrogetpostidobject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {
    public static String BASEURL = "https://jsonplaceholder.typicode.com/";

    public static Gson gson = new GsonBuilder().setLenient().create();

    public static Retrofit getRetro(){
        return new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
}
