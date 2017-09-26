package com.a00834304.photogalleryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EditImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnCrop:
                Intent cropIntent = new Intent(this, CropImageActivity.class);
                startActivity(cropIntent);
                break;
            case R.id.btnResize:
                Intent resizeIntent = new Intent(this, ResizeImageActivity.class);
                startActivity(resizeIntent);
                break;
        }
    }
}
