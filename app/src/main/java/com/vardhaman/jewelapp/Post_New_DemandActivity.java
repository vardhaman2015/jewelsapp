package com.vardhaman.jewelapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.vardhaman.jewelapp.Fragment.DiamondFragment;
import com.vardhaman.jewelapp.Fragment.GemsStoneFragment;
import com.vardhaman.jewelapp.Fragment.JewelleryFragment;


public class Post_New_DemandActivity extends ActionBarActivity {


    private android.support.design.widget.TabLayout tablayout;
    private Toolbar toolbaractionbar;
    Fragment fragment = null;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__new__demand);
        this.toolbaractionbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        this.tablayout = (TabLayout) findViewById(R.id.tab_layout);
        tablayout.addTab(tablayout.newTab().setText("Diamond"));
        tablayout.addTab(tablayout.newTab().setText("Gems Stone"));
        tablayout.addTab(tablayout.newTab().setText("Jewellery"));
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setSupportActionBar(toolbaractionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        fragmentManager = getFragmentManager();

        fragment = new DiamondFragment();

        if (fragment != null) {
            fragmentManager.beginTransaction().add(R.id.container_tab, fragment).commit();

        }
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("tab position", String.valueOf(tab.getPosition()));

                switch (tab.getPosition()){

                    case 0:
                       fragment = new DiamondFragment();

                        if (fragment != null) {
                            fragmentManager.beginTransaction().replace(R.id.container_tab, fragment).addToBackStack("Diamond").commit();

                        }
                        break;
                    case 1:
                        fragment = new GemsStoneFragment();

                        if (fragment != null) {
                            fragmentManager.beginTransaction().replace(R.id.container_tab, fragment).addToBackStack("GemsStones").commit();

                        }
                        break;
                    case 2:
                        fragment = new JewelleryFragment();

                        if (fragment != null) {
                            fragmentManager.beginTransaction().replace(R.id.container_tab, fragment).addToBackStack("Jewellery").commit();

                        }
                        Log.d("tab 2","tab 2 selected");
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post__new__demand, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()){

            case android.R.id.home:
                finish();
                return true;


        }
             return super.onOptionsItemSelected(item);
    }
}
