package com.a00834304.photogalleryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EditConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_confirm);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnOk:
                Intent okIntent = new Intent(this, SingleImageActivity.class);
                startActivity(okIntent);
                break;
            case R.id.btnCancel:
                Intent cancelIntent = new Intent(this, MainActivity.class);
                startActivity(cancelIntent);
                break;
        }
    }
}
