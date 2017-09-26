package com.a00834304.photogalleryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnKeyword:
                Intent keywordIntent = new Intent(this, KeywordSearchActivity.class);
                startActivity(keywordIntent);
                break;
            case R.id.btnDate:
                Intent dateIntent = new Intent(this, DateSearchActivity.class);
                startActivity(dateIntent);
                break;
        }
    }
}
