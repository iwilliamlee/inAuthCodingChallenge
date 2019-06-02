package com.application.myapplication;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.myapplication.giphy_activity.GiphyActivity;

public class MainActivity extends AppCompatActivity {


    Button searchGiphyButton;
    TextInputEditText mTextInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        searchGiphyButton = findViewById(R.id.get_giphys);
        searchGiphyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = mTextInputEditText.getText().toString();
                if(!query.isEmpty()) {
                    startActivity(GiphyActivity.getIntent(context, query));
                }
            }
        });

        mTextInputEditText = findViewById(R.id.tlet_giphy_search);
    }
}
