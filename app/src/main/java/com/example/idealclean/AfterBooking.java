package com.example.idealclean;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class AfterBooking extends AppCompatActivity {

  TextView thanksTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_booking);

        thanksTxt = findViewById(R.id.thanks);

        User user = SharedPrefManager.getInstance(this).getUser();

        thanksTxt.setText("Dear, "+user.getUsername()+", Your booking is successful," +
                " IdealClean will soon serve you, Thanks.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem logout = menu.findItem(R.id.action_logout);

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


    //

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                // Intent intent = new Intent(this, MainActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // startActivity(intent);

                //  findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
                // @Override
                //  public void onClick(View view) {
                //   finish();
                //  SharedPrefManager.getInstance(getApplicationContext()).logout();
                //     }
                //  });



                break;
            // Something else
            case R.id.action_contact:
                //   intent = new Intent(this, ThirdActivity.class);
                //  startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}