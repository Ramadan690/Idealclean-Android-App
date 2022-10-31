package com.example.idealclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Profile extends AppCompatActivity {

   TextView userTxt, totalTxt;

  // DatePicker dp;

    EditText addressTxt,dateTxt;

    static volatile int totalCount ;
   //int twoHours = 56,threeHours=84, fourHours=112, fiveHours=140, sixHours=168, sevenHours=196,
    //eightHours=224;

    EditText date;

    ProgressBar progressBar;

    TextView sp;

    boolean cFilled, hFilled, aFilled, tFilled;
    //dFilled, addFilled
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //if the user is not logged in
        //starting the login activity
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Login.class));
        }


        dateTxt = findViewById(R.id.dt);

        addressTxt = findViewById(R.id.address);

        userTxt =  findViewById(R.id.user);

      //  date = findViewById(R.id.dateSpinner);

        totalTxt =  findViewById(R.id.total);

        progressBar = findViewById(R.id.progress);

      //  sp = findViewById(R.id.spinner);

        //totalTxt.setText(Integer.toString(totalCount));

        //totalTxt.setText(totalCount);

        //halkaan

        Spinner cSpin = (Spinner) findViewById(R.id.crewSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> cAdapter = ArrayAdapter.createFromResource(this,
                R.array.crews, R.layout.tsize);
// Specify the layout to use when the list of choices appears
        cAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        cSpin.setAdapter(cAdapter);



        //halkaan

        cSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if(selectedItem.equals(" "))
                {

                    cFilled = false;
                }

                else if(selectedItem.equals("Any"))
                {
                    cFilled = true;
                    totalCount = 1;
                   // totalTxt.setText(Integer.toString(totalCount));
                    cSpin.setEnabled(false);
                }

                else if(selectedItem.equals("1 Cleaner"))
                {
                    cFilled = true;
                    totalCount = 1;
                 //   totalTxt.setText(Integer.toString(totalCount));
                    cSpin.setEnabled(false);
                }

                else if(selectedItem.equals("2 Cleaners"))
                {
                    cFilled = true;
                    totalCount = 2;
                  //  totalTxt.setText(Integer.toString(totalCount));
                    cSpin.setEnabled(false);
                }

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


        //halkaan




       // String txtFromSpinner = cSpin.getSelectedItem().toString();
      // sp.setText(txtFromSpinner);

        Spinner hSpin = (Spinner) findViewById(R.id.hourSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> hAdapter = ArrayAdapter.createFromResource(this,
                R.array.hours, R.layout.tsize);
// Specify the layout to use when the list of choices appears
        hAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        hSpin.setAdapter(hAdapter);

        //halkaan


        hSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if(selectedItem.equals(" "))
                {

                    hFilled = false;
                }


                else if(selectedItem.equals("2h (RM56)"))
                {
                    hFilled = true;
                    totalCount = totalCount*56;
                    totalTxt.setText(Integer.toString(totalCount));
                    hSpin.setEnabled(false);
                }

                else if(selectedItem.equals("3h (RM84)"))
                {
                    hFilled = true;
                    totalCount = totalCount*84;
                    totalTxt.setText(Integer.toString(totalCount));
                    hSpin.setEnabled(false);
                }

                else if(selectedItem.equals("4h (RM112)"))
                {
                    hFilled = true;
                    totalCount = totalCount*112;
                    totalTxt.setText(Integer.toString(totalCount));
                    hSpin.setEnabled(false);
                }

                else if(selectedItem.equals("5h (RM140)"))
                {
                    hFilled = true;
                    totalCount = totalCount*140;
                    totalTxt.setText(Integer.toString(totalCount));
                    hSpin.setEnabled(false);
                }

                else if(selectedItem.equals("6h (RM168)"))
                {
                    hFilled = true;
                    totalCount = totalCount*168;
                    totalTxt.setText(Integer.toString(totalCount));
                    hSpin.setEnabled(false);
                }

                else if(selectedItem.equals("7h (RM196)"))
                {
                    hFilled = true;
                    totalCount = totalCount*196;
                    totalTxt.setText(Integer.toString(totalCount));
                    hSpin.setEnabled(false);
                }

                else if(selectedItem.equals("8h (RM224)"))
                {
                    hFilled = true;
                    totalCount = totalCount*224;
                    totalTxt.setText(Integer.toString(totalCount));
                    hSpin.setEnabled(false);
                }

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });






        //halkaan






     //   totalTxt.setText(Integer.toString(totalCount));

        Spinner aSpin = (Spinner) findViewById(R.id.addonSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> aAdapter = ArrayAdapter.createFromResource(this,
                R.array.addon, R.layout.tsize);
// Specify the layout to use when the list of choices appears
        aAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        aSpin.setAdapter(aAdapter);


        aSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if(selectedItem.equals(" "))
                {

                    aFilled = false;
                }

                else if(selectedItem.equals("No"))
                {
                    aFilled = true;
                 //   totalCount=totalCount+25;
                 //   totalTxt.setText(Integer.toString(totalCount));
                    aSpin.setEnabled(false);
                }

                else if(selectedItem.equals("Yes"))
                {
                    aFilled = true;
                    totalCount=totalCount+25;
                    totalTxt.setText(Integer.toString(totalCount));
                    aSpin.setEnabled(false);
                }



            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });




        Spinner tSpin = (Spinner) findViewById(R.id.timeSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> tAdapter = ArrayAdapter.createFromResource(this,
                R.array.time, R.layout.tsize);
// Specify the layout to use when the list of choices appears
        tAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        tSpin.setAdapter(tAdapter);

        //halkaan

        tSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if(selectedItem.equals(" "))
                {

                    tFilled = false;
                }

                else if(selectedItem.equals("9am"))
                {
                    tFilled = true;
                    tSpin.setEnabled(false);
                }

               else if(selectedItem.equals("10am"))
                {
                    tFilled = true;
                    tSpin.setEnabled(false);
                }

                else if(selectedItem.equals("11am"))
                {
                    tFilled = true;
                    tSpin.setEnabled(false);
                }

                else if(selectedItem.equals("12pm"))
                {
                    tFilled = true;
                    tSpin.setEnabled(false);
                }

                else if(selectedItem.equals("1pm"))
                {
                    tFilled = true;
                    tSpin.setEnabled(false);
                }


                else if(selectedItem.equals("2pm"))
                {
                    tFilled = true;
                    tSpin.setEnabled(false);
                }

                else if(selectedItem.equals("3pm"))
                {
                    tFilled = true;
                    tSpin.setEnabled(false);
                }

                else if(selectedItem.equals("4pm"))
                {
                    tFilled = true;
                    tSpin.setEnabled(false);
                }


            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


//halkaan

        /*date spinner

        Spinner dSpin = (Spinner) findViewById(R.id.dateSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> dAdapter = ArrayAdapter.createFromResource(this,
                R.array.date, R.layout.tsize);
// Specify the layout to use when the list of choices appears
        dAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        dSpin.setAdapter(dAdapter);


        //halkaan

        dSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals(" "))
                {

                    dFilled = false;
                }

                else if(selectedItem.equals("Monday"))
                {
                    dFilled = true;
                    dSpin.setEnabled(false);
                }

                else if(selectedItem.equals("Tuesday"))
                {
                    dFilled = true;
                    dSpin.setEnabled(false);
                }

                else if(selectedItem.equals("Wednesday"))
                {
                    dFilled = true;
                    dSpin.setEnabled(false);
                }

                else if(selectedItem.equals("Thursday"))
                {
                    dFilled = true;
                    dSpin.setEnabled(false);
                }

                else if(selectedItem.equals("Friday"))
                {
                    dFilled = true;
                    dSpin.setEnabled(false);
                }


                else if(selectedItem.equals("Saturday"))
                {
                    dFilled = true;
                    dSpin.setEnabled(false);
                }

                else if(selectedItem.equals("Sunday"))
                {
                    dFilled = true;
                    dSpin.setEnabled(false);
                }




            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

     date spinner   */

//halkaan





        if (dateTxt.getText().toString().trim().length() > 0) {
           // dFilled = true;
        }

        if (addressTxt.getText().toString().trim().length() > 0) {
           // addFilled = true;
        }

/*
        if(dateTxt.getText().equals("")){

            dFilled = false;
        }

        else if(!dateTxt.getText().equals("")){

            dFilled = true;
        }

        if(addressTxt.getText().equals("")){

            addFilled = false;
        }

        else if(!addressTxt.getText().equals("")){

            addFilled = true;
        }


 */
        //halkaan


       // textViewUsername = (TextView) findViewById(R.id.textViewUsername);
       // textViewEmail = (TextView) findViewById(R.id.textViewEmail);
       // textViewGender = (TextView) findViewById(R.id.textViewGender);


        //getting the current user
        User user = SharedPrefManager.getInstance(this).getUser();

        //setting the values to the textviews
        //textViewId.setText(String.valueOf(user.getId()));

        //getting the loggedin user

                       userTxt.setText(user.getUsername());



        //textViewEmail.setText(user.getEmail());
        //textViewGender.setText(user.getGender());

        //when the user presses logout button
        //calling the logout method


        findViewById(R.id.book).setOnClickListener(new View.OnClickListener() {
           //halkaan

            @Override
            public void onClick(View v) {
                final String user,address,crew,hours,date,time,addon,total;
                user = String.valueOf(userTxt.getText());
                address = addressTxt.getText().toString();
                crew = cSpin.getSelectedItem().toString();
                hours = hSpin.getSelectedItem().toString();
                addon = aSpin.getSelectedItem().toString();
            //    date = dSpin.getSelectedItem().toString();
                date = dateTxt.getText().toString();
                time = tSpin.getSelectedItem().toString();
                total = String.valueOf(totalTxt.getText());

              //  if(!filled.equals("no") )

                if(cFilled&&hFilled&&tFilled&&aFilled&&addEmpty()&&dateEmpty()) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[8];
                            field[0] = "user";
                            field[1] = "address";
                            field[2] = "crew";
                            field[3] = "hours";
                            field[4] = "addon";
                            field[5] = "date";
                            field[6] = "time";
                            field[7] = "total";
                            String[] data = new String[8];
                            data[0] = user;
                            data[1] = address;
                            data[2] = crew;
                            data[3] = hours;
                            data[4] = addon;
                            data[5] = date;
                            data[6] = time;
                            data[7] = total;
                            PutData putData = new PutData("http://10.0.2.2/idealclean/booking.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Successfully Booked")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), AfterBooking.class);
                                       startActivity(intent);
                                       finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                                Intent intent = new Intent(getApplicationContext(), AfterBooking.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please, remember filling fields", Toast.LENGTH_SHORT).show();
                }
            }


            //halkaan
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem logout = menu.findItem(R.id.action_logout);

        MenuItem contact = menu.findItem(R.id.action_contact);

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
                // Intent intent = new Intent(Profile.this, Contact.class);
                //  startActivity(intent);

                //finish();
               // SharedPrefManager.getInstance(getApplicationContext()).logout();



                Intent intent = new Intent(getApplicationContext(), Trans.class);
                startActivity(intent);
                finish();
                return false;
            }

            //halkaan




            //halkaan

        });

        contact.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Intent intent = new Intent(Profile.this, Contact.class);
                //  startActivity(intent);

                //finish();
                // SharedPrefManager.getInstance(getApplicationContext()).logout();



                Intent intent = new Intent(getApplicationContext(), Contact.class);
                startActivity(intent);
                finish();
                return false;
            }

            //halkaan




            //halkaan

        });





        return true;
    }

    private boolean addEmpty() {
        if (addressTxt.getText().toString().trim().length() > 0)
            return true;

        return false;
    }
    private boolean dateEmpty() {
        if (dateTxt.getText().toString().trim().length() > 0)
            return true;

        return false;
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

    //



}