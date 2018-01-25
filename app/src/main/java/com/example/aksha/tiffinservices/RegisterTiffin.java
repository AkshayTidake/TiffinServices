package com.example.aksha.tiffinservices;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cloudoperations.FireStoreAccess;
import model.DataModel;

public class RegisterTiffin extends AppCompatActivity {
TextInputLayout tilname,tilsername,tilemail,tilcountry,tilstate,tilcity,tilarea,tilcontact,tilpin,tilpasswd;
TextInputEditText tinam,tisname,tiemail,ticountry,tistate,ticity,tiarea,ticontact,tipin,tipasswd;
Button registerbtn,deletebtn;

FireStoreAccess f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        f = new FireStoreAccess(this);
        tilname = findViewById(R.id.tname);
        tinam = findViewById(R.id.name);
        tisname = findViewById(R.id.sname);
        tiemail = findViewById(R.id.email);
        ticountry = findViewById(R.id.country);
        tistate = findViewById(R.id.state);
        ticity = findViewById(R.id.city);
        tiarea = findViewById(R.id.area);
        ticontact = findViewById(R.id.contact);
        tipin = findViewById(R.id.pincode);
        tipasswd = findViewById(R.id.passwd);

        registerbtn = findViewById(R.id.regbutton);
        deletebtn = findViewById(R.id.delbutton);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.registerUser(tinam.getText().toString(),tisname.getText().toString()
                        ,tiemail.getText().toString(),ticountry.getText().toString(),
                        tistate.getText().toString(),ticity.getText().toString(),
                        tiarea.getText().toString(),ticontact.getText().toString(),
                        tipin.getText().toString(),tipasswd.getText().toString());
                startActivity(new Intent(RegisterTiffin.this,LoginScreen.class));
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.deleteData(tiemail.getText().toString());
            }
        });
    }
}
