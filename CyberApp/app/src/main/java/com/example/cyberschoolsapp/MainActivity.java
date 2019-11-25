package com.example.cyberschoolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    {
        Button button;
        Button buttonreg;
        TextView forgotpass;
        //Step 01
        EditText UsernameEt;
        EditText PasswordEt;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);




            //Step 02
            UsernameEt=(EditText) findViewById(R.id.etUsername);
            PasswordEt=(EditText) findViewById(R.id.etPassword);
            forgotpass=(TextView) findViewById(R.id.forgot);
            forgotpass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity4();
                }
            });
            button=(Button) findViewById(R.id.btnLogin);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    openActivity2();
                }
            });
            buttonreg=(Button) findViewById(R.id.buttonRegi);
            buttonreg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity3();
                }
            });
        }
            public void openActivity2()
            {
                Intent intent=new Intent(this,Home.class);
                startActivity(intent);
            }
        public void openActivity3()
        {
            Intent intent=new Intent(this,Registration.class);
            startActivity(intent);
        }
        public void openActivity4()
        {
            Intent intent=new Intent(this,ForgotPassword.class);
            startActivity(intent);
        }
        //Step 04
        public void OnLogin(View view)
        {
            String username=UsernameEt.getText().toString();
            String password=PasswordEt.getText().toString();
            //Step 11
            String type="Login";
            //Step 09
            BackgroundWorker backgroundWorker=new BackgroundWorker(this);
            //Step 10
            backgroundWorker.execute(type,username,password);
        }
    }
