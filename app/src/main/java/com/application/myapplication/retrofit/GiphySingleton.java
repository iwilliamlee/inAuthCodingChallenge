package com.application.myapplication.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GiphySingleton {

    public Retrofit retrofit;
    private static GiphySingleton sGiphySingleton;

    public GiphySingleton get() {
        if(sGiphySingleton == null) {
            sGiphySingleton = new GiphySingleton();
        }
        return sGiphySingleton;
    }

    private GiphySingleton() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        this.retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.giphy.com/v1/gifs/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
