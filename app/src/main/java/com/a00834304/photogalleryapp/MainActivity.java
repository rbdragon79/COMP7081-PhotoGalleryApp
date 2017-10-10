package com.a00834304.photogalleryapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String dbName = "tempDB.db";
        SQLiteDatabase db = openOrCreateDatabase(dbName, 0, null);

        if(!db.isOpen()) {
            Toast.makeText(this, "Db Open Error", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        db.beginTransaction();
        try{
            db.execSQL("DROP TABLE IF EXISTS 'PhotoGalleryApp'");
            db.execSQL("CREATE TABLE IF NOT EXISTS "
                    + "PhotoGalleryApp"
                    + " (name VARCHAR, date VARCHAR, image VARCHAR);");

            db.execSQL("INSERT INTO PhotoGalleryApp (name , date, image) VALUES ('tn01','2017-10-03',' " + getImage1() + "');");
            db.execSQL("INSERT INTO PhotoGalleryApp (name , date, image) VALUES ('tn02','2017-10-02',' " + getImage2() + "');");
            db.execSQL("INSERT INTO PhotoGalleryApp (name , date, image) VALUES ('tn03','2017-10-01',' " + getImage3() + "');");
            db.setTransactionSuccessful();
            Toast.makeText(this, "Database Created Successfully", Toast.LENGTH_LONG)
                    .show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally
        {
            db.endTransaction();
        }
        Cursor dbCursor = null;
        StringBuilder builder = new StringBuilder();

        if(!db.isOpen()) {
            Toast.makeText(this, "Db Open Error", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.img_tn01:
                Intent singleImageIntent = new Intent(this, SingleImageActivity.class);
                startActivity(singleImageIntent);
                break;
            case R.id.imgSearch:
                Intent searchIntent = new Intent(this, SearchActivity.class);
                startActivity(searchIntent);
                break;
        }
    }

    public String getImage1() {
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tn01);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte [] bitmapdata = stream.toByteArray();
        String converted = Base64.encodeToString(bitmapdata, Base64.DEFAULT);
        return converted;
    }

    public String getImage2() {
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tn02);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte [] bitmapdata = stream.toByteArray();
        String converted = Base64.encodeToString(bitmapdata, Base64.DEFAULT);
        return converted;
    }

    public String getImage3() {
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tn03);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte [] bitmapdata = stream.toByteArray();
        String converted = Base64.encodeToString(bitmapdata, Base64.DEFAULT);
        return converted;
    }

}
