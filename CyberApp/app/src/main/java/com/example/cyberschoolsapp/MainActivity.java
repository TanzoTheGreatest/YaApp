package com.example.cyberschoolsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //Step 01

    Button buttonlogin;
    Button buttonreg;
    TextView forgotpass;


    EditText UsernameEt;
    EditText PasswordEt;
    EditText mail;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Step 02
        UsernameEt = (EditText) findViewById(R.id.email);
        PasswordEt = (EditText) findViewById(R.id.pass);
        mail = findViewById(R.id.email);
        forgotpass = (TextView) findViewById(R.id.forgot);
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        buttonlogin = (Button) findViewById(R.id.btnLogin);
        fAuth = FirebaseAuth.getInstance();

           buttonlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    openActivity2();
                }
            });
            buttonreg=(Button) findViewById(R.id.buttonReg);
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


        public void openActivity4 () {
            Intent intent = new Intent(this, ForgotPassword.class);
            startActivity(intent);
        }
        //Step 04
        public void OnLogin (View view)
        {
            String username = UsernameEt.getText().toString();
            String password = PasswordEt.getText().toString();
            //Step 11
            String type = "Login";
            //Step 09
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            //Step 10
            backgroundWorker.execute(type, username, password);


            //Event Listener for the buttons

            buttonlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = mail.getText().toString().trim();
                    String password = PasswordEt.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        mail.setError("Email is required");
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        PasswordEt.setError("Password is required");
                    }
                    if (password.length() < 5) {
                        PasswordEt.setError("Password must have more than 5 characters");
                    }
                    fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Home.class));
                            } else {
                                Toast.makeText(MainActivity.this, "Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });

        }
    }

