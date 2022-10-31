package com.example.idealclean;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class AfterContact extends AppCompatActivity {

    TextView thanksTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_contact);

        thanksTxt = findViewById(R.id.thanks);

        User user = SharedPrefManager.getInstance(this).getUser();

        thanksTxt.setText("Dear, "+user.getUsername()+", Your message is sent successfully," +
                " IdealClean will soon serve you, Thanks.");
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


        return true;
    }

}