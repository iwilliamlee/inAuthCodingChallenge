package com.application.myapplication.retrofit;


import io.reactivex.Observable;
import retrofit2.http.Query;

public interface GiphyService {

    public static final String API_KEY = "HfQl65WIsUozzymYWvvsrNOZOdNB6szA";

    public Observable<GiphyResponse.Result> searchGiphy(
            @Query("api_key") String apiKey,
            @Query("q") String query,
            @Query("limit") Integer limit,
            @Query("offset") Integer offset,
            @Query("rating") String rating,
            @Query("lang") String lang);

}
