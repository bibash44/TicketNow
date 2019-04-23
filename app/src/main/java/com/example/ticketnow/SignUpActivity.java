package com.example.ticketnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.app.ActionBar;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    TextView login_link;

//    Toolbar signup_toolbar;
//    ActionBar signup_actionbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        login_link=findViewById(R.id.link_to_login);
        login_link.setOnClickListener(this);

        /*signup_toolbar=findViewById(R.id.signup_toolbar);
        setSupportActionBar(signup_toolbar);

        signup_actionbar=getSupportActionBar();
        signup_actionbar.setTitle("Signup form");*/
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.link_to_login){
            final Intent login_intent= new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(login_intent);
        }
    }
}
