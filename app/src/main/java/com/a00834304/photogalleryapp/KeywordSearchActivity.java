package com.a00834304.photogalleryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class KeywordSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyword_search);
    }

    public void onClick(View v) {
        Intent searchIntent = new Intent(this, MainActivity.class);
        startActivity(searchIntent);
    }
}
