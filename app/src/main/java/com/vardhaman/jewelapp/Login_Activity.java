package com.vardhaman.jewelapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Login_Activity extends ActionBarActivity {

    Button  submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        TextView tvsignup = (TextView) findViewById(R.id.tvsignup);
        TextView tvfpass = (TextView) findViewById(R.id.tvfpass);
        EditText password = (EditText) findViewById(R.id.password);
        EditText mobileno = (EditText) findViewById(R.id.mobile_no);
        submit = (Button)findViewById(R.id.bsubmit);

        password.setTextColor(Color.BLACK);
        mobileno.setTextColor(Color.BLACK);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(getBaseContext(), "Welcome User_name", Toast.LENGTH_SHORT).show();

            }
        });

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this,SignupActivity.class));
            }
        });
        tvfpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this, ForgotActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
