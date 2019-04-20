package com.example.ticketnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView signup_llink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup_llink=findViewById(R.id.link_to_signup);

        signup_llink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.link_to_signup){
            final Intent signup_intent= new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(signup_intent);
        }
    }
}
