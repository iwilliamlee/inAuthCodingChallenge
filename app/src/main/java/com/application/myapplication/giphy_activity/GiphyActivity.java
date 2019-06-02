package com.application.myapplication.giphy_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GiphyActivity extends AppCompatActivity {

    private final static String QUERY = "query";

    public static Intent getIntent(Context context, String giphyQuery) {
        Intent intent = new Intent(context, GiphyActivity.class);
        intent.putExtra(QUERY, giphyQuery);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String query = getIntent().getStringExtra(QUERY);
        getSupportActionBar().setTitle(query);


    }

}
