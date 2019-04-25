package com.example.ticketnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView signup_llink;
    EditText txt_email, txt_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Initializing text view for link to signup form*/
        signup_llink=findViewById(R.id.link_to_signup);
        signup_llink.setOnClickListener(this);

        /*Initialization of text input fields*/
        txt_email=findViewById(R.id.txt_email);
        txt_password=findViewById(R.id.txt_password);


        /*Initializing button for login*/
        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*On click event for link to signup form*/
        if(v.getId()==R.id.link_to_signup){
            final Intent signup_intent= new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(signup_intent);
        }

        /*On click event for login button*/
        String email, password;
        email=txt_email.getText().toString();
        password=txt_password.getText().toString();

        if(v.getId()==R.id.btn_login){
            if (email.isEmpty()){
                txt_email.setError("Please enter your email");
                txt_email.requestFocus();
            }

            else if(password.isEmpty()){
                txt_password.setError("Please enter yor password");
                txt_password.requestFocus();
            }

            else{
                /*Code to match the email and password*/
            }
        }
    }


}
