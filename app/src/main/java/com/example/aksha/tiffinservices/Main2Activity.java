package com.example.aksha.tiffinservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
CardView tiffinregcard,hostelregcard,userregcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tiffinregcard = findViewById(R.id.tiffincard);
        hostelregcard = findViewById(R.id.hostelcard);
        userregcard = findViewById(R.id.usercard);

        tiffinregcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,RegisterTiffin.class));
            }
        });

      hostelregcard.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(Main2Activity.this,RegisterTiffin.class));
          }
      });

      userregcard.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(Main2Activity.this,RegisterTiffin.class));
          }
      });
    }




}
