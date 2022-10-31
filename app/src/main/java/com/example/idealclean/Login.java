package com.example.idealclean;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Login extends AppCompatActivity {





    public String userName;

        TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
        Button buttonLogin;
        TextView textViewSignUp;
        ProgressBar progressBar;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            textInputEditTextUsername = findViewById(R.id.username);
            textInputEditTextPassword = findViewById(R.id.password);
            buttonLogin = findViewById(R.id.buttonLogin);
            textViewSignUp = findViewById(R.id.signUpText);
            progressBar = findViewById(R.id.progress);

            textViewSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), SignUp.class);
                    startActivity(intent);
                    finish();
                }
            });
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String fullname, username, password, email;
                    username = String.valueOf(textInputEditTextUsername.getText());
                    password = String.valueOf(textInputEditTextPassword.getText());

                    if(!username.equals("") && !password.equals("")) {
                        progressBar.setVisibility(View.VISIBLE);
                        Handler handler = new Handler();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                String[] field = new String[2];
                                field[0] = "username";
                                field[1] = "password";
                                String[] data = new String[2];
                                data[0] = username;
                                data[1] = password;

                                userName = data[0];

                                PutData putData = new PutData("http://10.0.2.2/idealclean/login.php", "POST", field, data);
                                if (putData.startPut()) {
                                    if (putData.onComplete()) {
                                        progressBar.setVisibility(View.GONE);
                                        String result = putData.getResult();
                                        if(result.equals("Login Success")){

                                            //creating a new user object
                                            User user = new User(
                                                  //  userJson.getInt("id"),
                                                    userName
                                                 //   userJson.getString("email"),
                                                 //   userJson.getString("gender")
                                            );


                                            //storing the user in shared preferences
                                            SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                                            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), Profile.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                        else {
                                            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                        });
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }