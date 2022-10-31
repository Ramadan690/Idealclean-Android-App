package com.example.idealclean;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Trans extends AppCompatActivity {

    TextView textView;
    RequestQueue queue;
    String URL = "http://10.0.2.2/idealclean/tran2.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);

        textView = findViewById(R.id.text);
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response.toString());
                try {
                    JSONObject object=new JSONObject(response);
                    JSONArray array=object.getJSONArray("user");
                    for(int i=0;i<array.length();i++) {
                        JSONObject object1=array.getJSONObject(0);
                        String user =object1.getString("name");
                        UserInfo userInfo=new UserInfo(user);
                        textView.setText(userInfo.name);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());
            }
        });
        queue.add(request);
    }
    private class UserInfo {
        String name;
        public UserInfo(String name) {
            this.name=name;
        }
    }
}