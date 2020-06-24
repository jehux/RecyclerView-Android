package com.example.recyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView mTitleTv, mDescrTv;
    ImageView mImageIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();

        mTitleTv = findViewById(R.id.dTitleTv);
        mDescrTv = findViewById(R.id.dDescrTv);
        mImageIv = findViewById(R.id.dImageIv);

        //Intent
        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("iTitle");
        String mDescr = intent.getStringExtra("iDescr");
        byte[] mBytes = getIntent().getByteArrayExtra("iImage");
        //Decode bytes array to bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        //Set title to actionbar
        actionBar.setTitle(mTitle);

        //set data to our views
        mTitleTv.setText(mTitle);
        mImageIv.setImageBitmap(bitmap);
        mDescrTv.setText(mDescr);
    }
}
