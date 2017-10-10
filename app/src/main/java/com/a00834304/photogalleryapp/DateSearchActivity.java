package com.a00834304.photogalleryapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DateSearchActivity extends AppCompatActivity implements OnClickListener {

    String dbName;
    SQLiteDatabase db;
    Button search;
    ImageView image;
    EditText searchDate;
    String imageString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_search);

        dbName = "tempDB.db";
        db = openOrCreateDatabase(dbName, 0, null);

        if(!db.isOpen()) {
            Toast.makeText(this, "Db Open Error", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        search = (Button) findViewById(R.id.btnSearch);
        search.setOnClickListener(this);

        image = (ImageView) findViewById(R.id.imgResult);
        searchDate = (EditText) findViewById(R.id.editDate);
    }

    public void onClick(View v) {

        if(v == search) {
            String query = "SELECT * FROM PhotoGalleryApp WHERE date = '" + searchDate.getText().toString() + "'";
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.getCount() <= 0) {
                Toast.makeText(this, "No Image Found For The Date Entered: (" + searchDate.getText().toString() + ")", Toast.LENGTH_LONG).show();
                image.setImageResource(R.drawable.blank);
                return;
            } else {
                searchDate.setText("");
                cursor.moveToFirst();
                //Toast.makeText(this, cursor.getString(cursor.getColumnIndex("date")), Toast.LENGTH_LONG).show();
                //return;
                String imageString = cursor.getString(cursor.getColumnIndex("image"));
                byte [] bitmapdata = Base64.decode(imageString, Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length);
                image.setImageBitmap(bitmap);
                return;
            }
        }
    }
}
