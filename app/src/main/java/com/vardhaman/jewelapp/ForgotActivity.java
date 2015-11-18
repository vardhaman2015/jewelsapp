package com.vardhaman.jewelapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class ForgotActivity extends AppCompatActivity {

    private android.widget.EditText forgotemail;
    private android.widget.Button bsubmit;
    private android.widget.Button bcancel;
    private android.widget.LinearLayout forgetpwdpopup;
    private Toolbar toolbaractionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        this.toolbaractionbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        this.forgetpwdpopup = (LinearLayout) findViewById(R.id.forgetpwd_popup);
       // this.bcancel = (Button) findViewById(R.id.bcancel);
        this.bsubmit = (Button) findViewById(R.id.bsubmit);
        this.forgotemail = (EditText) findViewById(R.id.forgot_email);

        setSupportActionBar(toolbaractionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbaractionbar.setTitle("Forgot Password");
        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Password successfully send to your Email-id",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ForgotActivity.this,Login_Activity.class));
            }
        });
     /*   bcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forgot, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
