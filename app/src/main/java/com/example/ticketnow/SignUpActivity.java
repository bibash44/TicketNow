package com.example.ticketnow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView login_link;
    private Button btn_signup;
    private EditText txt_fullname, txt_email, txt_phone, txt_password, txt_cpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /*Initialization text view for link to login form*/
        login_link = findViewById(R.id.link_to_login);
        login_link.setOnClickListener(this);

        /*Initialization of buttons*/
        btn_signup = findViewById(R.id.btn_sign_up);
        btn_signup.setOnClickListener(this);


        /*Initialization of input fields*/
        txt_fullname = findViewById(R.id.txt_fullname);
        txt_email = findViewById(R.id.txt_email);
        txt_phone = findViewById(R.id.txt_phone);
        txt_password = findViewById(R.id.txt_password);
        txt_cpassword = findViewById(R.id.txt_cpassword);


    }

    @Override
    public void onClick(View v) {

        /*On click event for link to login form*/
        if (v.getId() == R.id.link_to_login) {
            final Intent login_intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(login_intent);
        }

        String fullname, email, phone, password, cpassword;

        /*On click event for sign up button with validation*/
        /*getting string values  from input fields*/
        fullname = txt_fullname.getText().toString();
        email = txt_email.getText().toString();
        phone = txt_phone.getText().toString();
        password = txt_password.getText().toString();
        cpassword = txt_cpassword.getText().toString();

        if (v.getId() == R.id.btn_sign_up) {

            /*validation for using regular expressions*/

            if (fullname.isEmpty()) {
                txt_fullname.setError("Please enter a name");
                txt_fullname.requestFocus();
            }

            else if(!fullname.isEmpty() && !fullname.matches("[a-z a-z A-Z A-Z]+")){
                txt_fullname.setError("Please enter a valid name");
                txt_fullname.requestFocus();
            }

            else if (email.isEmpty()) {
                txt_email.setError("Please enter your email");
                txt_email.requestFocus();
            }

            else if(!email.isEmpty() && !email.matches("^[0-9a-zA-Z!#$%&;'*+\\-/\\=\\?\\^_`\\.{|}~]{1,64}@[0-9a-zA-Z]{1,255}\\.[a-zA-Z]{1,10}")){
                txt_email.setError("Email is invalid, please match the email format");
                txt_email.requestFocus();
            }


            else if (phone.isEmpty()) {
                txt_phone.setError("Please enter your phone number");
                txt_phone.requestFocus();
            }

            else if (!phone.isEmpty() && !phone.matches("[+ 0-9].{6,10}")) {
                txt_phone.setError("Phone number can include + and must be minimum character up to 7 and maximum up to 10 character only");
                txt_phone.requestFocus();
            }



            else if (password.isEmpty()) {
                txt_password.setError("Please enter your password");
                txt_password.requestFocus();
            }


            else if (!password.isEmpty() && !password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}")) {
                txt_password.setError("Must contain at least one number and one uppercase and lowercase letter, and include at least 6 or more characters");
                txt_password.requestFocus();
            }


            else if (cpassword.isEmpty()) {
                    txt_cpassword.setError("Please re-enter your password");
                txt_cpassword.requestFocus();
            }

            else if (!cpassword.isEmpty() && !cpassword.equals(password)) {
                txt_cpassword.setError("Password didnot match, re-enter same password");
                txt_cpassword.requestFocus();
            }


            else{
                final ProgressDialog progressDialog= new ProgressDialog(this);
                progressDialog.setTitle("Signing up");
                progressDialog.setMessage("Please Wait!");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setProgress(50);
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        }
    }
}
