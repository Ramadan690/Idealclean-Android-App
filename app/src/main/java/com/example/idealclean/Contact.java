package com.example.idealclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Contact extends AppCompatActivity {

    EditText et;

    Button sm;

    String userTxt1;

    TextView userTxt;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        et = findViewById(R.id.contactTxt);

        sm = findViewById(R.id.contactBtn);

        progressBar = findViewById(R.id.progress);

        userTxt = findViewById(R.id.usr);

        User user = SharedPrefManager.getInstance(this).getUser();
        userTxt.setText(user.getUsername());

        userTxt.setVisibility(TextView.INVISIBLE);

        //getting the loggedin user



        //halkaan

        findViewById(R.id.contactBtn).setOnClickListener(new View.OnClickListener() {
            //halkaan

            @Override
            public void onClick(View v) {
                final String user,message;



                user = String.valueOf(userTxt.getText());
                message = et.getText().toString();


                //  if(!filled.equals("no") )

           //     if(cFilled&&hFilled&&tFilled&&aFilled&&addEmpty()&&dateEmpty())

                    if(messageEmpty()) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "user";
                            field[1] = "message";

                            String[] data = new String[2];
                            data[0] = user;
                            data[1] = message;

                            PutData putData = new PutData("http://10.0.2.2/idealclean/contact.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Message sent Successfully")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                       // Intent intent = new Intent(getApplicationContext(), AfterContact.class);
                                       // startActivity(intent);
                                      //  finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                                Intent intent = new Intent(getApplicationContext(), AfterContact.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please, remember writing your message", Toast.LENGTH_SHORT).show();
                }
            }


            //halkaan
        });

        //halkaan

    }

    private boolean messageEmpty() {
        if (et.getText().toString().trim().length() > 0)
            return true;

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem logout = menu.findItem(R.id.action_logout);

        MenuItem history = menu.findItem(R.id.action_history);

        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //  Intent intent = new Intent(SelectActivity.this, DownActivity.class);
                //  startActivity(intent);

                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();

                return false;
            }
        });




        history.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //  Intent intent = new Intent(SelectActivity.this, DownActivity.class);
                //  startActivity(intent);

               // finish();
               // SharedPrefManager.getInstance(getApplicationContext()).logout();


                //halkaan


                    final String user,message;



                    user = String.valueOf(userTxt.getText());
                    message = et.getText().toString();


                    //  if(!filled.equals("no") )

                    //     if(cFilled&&hFilled&&tFilled&&aFilled&&addEmpty()&&dateEmpty())

                    if(messageEmpty()) {
                        progressBar.setVisibility(View.VISIBLE);
                        Handler handler = new Handler();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                String[] field = new String[1];
                                field[0] = "user";


                                String[] data = new String[1];
                                data[0] = user;


                                PutData putData = new PutData("http://10.0.2.2/idealclean/transhistory.php", "POST", field, data);
                                if (putData.startPut()) {
                                    if (putData.onComplete()) {
                                        progressBar.setVisibility(View.GONE);
                                        String result = putData.getResult();
                                        if(result.equals("Transactions Found")){
                                            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                            // Intent intent = new Intent(getApplicationContext(), AfterContact.class);
                                            // startActivity(intent);
                                            //  finish();
                                        }
                                        else {
                                            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    Intent intent = new Intent(getApplicationContext(), Trans.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Please, remember writing your message", Toast.LENGTH_SHORT).show();
                    }

                Intent intent = new Intent(getApplicationContext(), Trans.class);
                startActivity(intent);
                finish();
                return false;


            }
        });


        return true;
    }

}