package com.a00834304.photogalleryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ResizeImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resize_image);
    }

    public void onClick(View v) {
        Intent confirmIntent = new Intent(this, EditConfirmActivity.class);
        startActivity(confirmIntent);
    }
}
