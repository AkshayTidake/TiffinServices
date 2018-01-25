package com.example.aksha.tiffinservices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import cloudoperations.FireStoreAccess;

public class ShowList extends AppCompatActivity {
TextView tv;
FireStoreAccess fs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv = findViewById(R.id.text);
        fs = new FireStoreAccess(this);
        fs.readUser(tv);


    }
}
