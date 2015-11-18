package com.vardhaman.jewelapp;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.vardhaman.jewelapp.Fragment.Contact_UsFragment;
import com.vardhaman.jewelapp.Fragment.InviteContactFragment;
import com.vardhaman.jewelapp.Fragment.MyProfileFragment;
import com.vardhaman.jewelapp.Fragment.My_ResponseFragment;
import com.vardhaman.jewelapp.Fragment.NavigationDrawerFragment;
import com.vardhaman.jewelapp.Fragment.PostFragment;
import com.vardhaman.jewelapp.Fragment.PulseFragment;
import com.vardhaman.jewelapp.Fragment.SettingFragment;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    public static android.support.design.widget.FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fab = (FloatingActionButton) findViewById(R.id.fab);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.myPrimaryDarkColor));
        }

       /* Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(activity.getResources().getColor(R.color.example_color));*/

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Post_New_DemandActivity.class));
            }
        });
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);


        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer
        mNavigationDrawerFragment.setUserData("Ishank", "ishank.pce@gmail.com", BitmapFactory.decodeResource(getResources(), R.drawable.avatar));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
       // Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
        fragment=null;
        fragmentManager = getFragmentManager();
        switch (position){

            case 0:
                fragment = new PulseFragment();
                break;
            case 1:
                fragment = new PostFragment();
                break;
            case 2:
                fragment = new My_ResponseFragment();
                break;
            case 4:
                fragment = new MyProfileFragment();
                break;
            case 5:
                fragment = new InviteContactFragment();
                break;
            case 7:
                fragment=null;
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                // Setting Dialog Title
                alertDialog.setTitle("Logout");

                // Setting Dialog Message
                /*alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");*/
                alertDialog.setMessage("Are you sure...?");

                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, "Log Out Successfully", Toast.LENGTH_LONG).show();
                        finish();
                        Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });

                // on pressing cancel button
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
                break;


        }
        if (fragment != null) {
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

        }
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            MenuItem setting = menu.findItem(R.id.action_settings);
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Fragment fragment = null;
        FragmentManager fragmentManager = getFragmentManager();

        switch (item.getItemId()){

                case R.id.action_contacts:

                    fragment = new Contact_UsFragment();

                    if (fragment != null) {
                        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

                    }
                    break;

            case R.id.action_settings:


                fragment = new SettingFragment();

                if (fragment != null) {
                    fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

                }
                break;


        }
        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }


}
