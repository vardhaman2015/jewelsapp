package com.vardhaman.jewelapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends ActionBarActivity {

    private android.widget.EditText name;
    private android.widget.EditText regmobileno;
    private android.widget.EditText email;
    private android.widget.EditText regpassword;
    private android.widget.Button btreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.btreg = (Button) findViewById(R.id.btreg);
        this.regpassword = (EditText) findViewById(R.id.reg_password);
        this.email = (EditText) findViewById(R.id.email);
        this.regmobileno = (EditText) findViewById(R.id.reg_mobile_no);
        this.name = (EditText) findViewById(R.id.name);

        btreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Registration done successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignupActivity.this,MainActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
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
