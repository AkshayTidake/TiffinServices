package com.example.aksha.tiffinservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {
    EditText username,pass;
    Button login,register,showlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        username = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.loginbtn);
        register = (Button)findViewById(R.id.registerbtn);
        showlist = findViewById(R.id.showlist);

        showlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginScreen.this,ShowList.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginScreen.this,Main2Activity.class));
            }
        });
    }


}
