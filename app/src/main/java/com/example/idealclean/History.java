package com.example.idealclean;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class History extends AppCompatActivity {

    Transactions trans;

    EditText et;

    Button sm;

    String userTxt1;

    TextView userTxt;

    ProgressBar progressBar;

    EditText et2, et3;

    Button btnBack, btnRetrieve;

    TextView tvid,tvuser,tvaddress,tvdate,tvtotal;

    String id,usr,add,dt,tt;

    String url ="http://10.0.2.2/idealclean/tran2.php";

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

       // et = findViewById(R.id.contactTxt);

        sm = findViewById(R.id.contactBtn);

       // btnRetrieve = findViewById(R.id.retrieveBtn);

        progressBar = findViewById(R.id.progress);


        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvuser = findViewById(R.id.txuser);
        tvaddress = findViewById(R.id.txaddress);
        tvdate = findViewById(R.id.txdate);
        tvtotal = findViewById(R.id.txtotal);

        userTxt = findViewById(R.id.usr);


        User user = SharedPrefManager.getInstance(this).getUser();
        userTxt.setText(user.getUsername());

        userTxt.setVisibility(TextView.INVISIBLE);

      //  tvid.setVisibility(TextView.INVISIBLE);
      //  tvuser.setVisibility(TextView.INVISIBLE);
      //  tvaddress.setVisibility(TextView.INVISIBLE);
      //  tvdate.setVisibility(TextView.INVISIBLE);
       // tvtotal.setVisibility(TextView.INVISIBLE);

  //      Intent intent =getIntent();
//        position = intent.getExtras().getInt("position");

        //getting the loggedin user



        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://10.0.2.2/idealclean/tran2.php";

       // String url ="http://10.0.2.2/idealclean/transhistory.php";

        //halkaan


        btnBack = (Button) findViewById(R.id.backBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user;
              //  username = String.valueOf(textInputEditTextUsername.getText());
              //  password = String.valueOf(textInputEditTextPassword.getText());

                user=String.valueOf(userTxt.getText());

                if(!user.equals("") ) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[1];
                            field[0] = "user";

                            String[] data = new String[1];
                            data[0] = user;



                            PutData putData = new PutData("http://10.0.2.2/idealclean/tran2.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Transactions Found")){

                                        tvid.setVisibility(TextView.VISIBLE);
                                        tvuser.setVisibility(TextView.VISIBLE);
                                        tvaddress.setVisibility(TextView.VISIBLE);
                                        tvdate.setVisibility(TextView.VISIBLE);
                                        tvtotal.setVisibility(TextView.VISIBLE);

                                        StringRequest request = new StringRequest(Request.Method.POST, url,
                                                new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {

                                                        //halkaan

                                                        tvid.setText(response.toString());



                                                        try {
                                                            JSONObject jsonObject = new JSONObject(response);
                                                            String sucess = jsonObject.getString("success");
                                                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                                                            if (sucess.equals("1")) {


                                                                for (int i = 0; i < jsonArray.length(); i++) {

                                                                    JSONObject object = jsonArray.getJSONObject(i);




                                                                    JSONObject jo = jsonArray.optJSONObject(i);
                                                                    String ID = jo.optString("id");
                                                                    String USER = jo.optString("user");
                                                                    String ADD = jo.optString("add");
                                                                    String DATE = jo.optString("date");
                                                                    String TOTAL = jo.optString("total");

                                                                    tvid.setText(ID);
                                                                    tvuser.setText(USER);
                                                                    tvaddress.setText(ADD);
                                                                    tvdate.setText(DATE);
                                                                    tvtotal.setText(TOTAL);




                                                                }
                                                            }
                                                        } catch (JSONException e) {
                                                            e.printStackTrace();
                                                        }
                                                    }

                                                },new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                Toast.makeText(History.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });


                                        RequestQueue requestQueue = Volley.newRequestQueue(History.this);
                                        requestQueue.add(request);

                                        tvid.setText(request.toString());



                                        //halkaan


                                        /*
                                        //creating a new user object
                                        User user = new User(
                                                //  userJson.getInt("id"),
                                                userName
                                                //   userJson.getString("email"),
                                                //   userJson.getString("gender")
                                        );

*/
                                        //storing the user in shared preferences
                                       // SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

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

    //halkaan




}    //halkaan