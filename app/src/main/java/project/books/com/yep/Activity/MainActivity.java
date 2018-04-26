package project.books.com.yep.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import project.books.com.yep.Adapter.NavimenuListAdapter;
import project.books.com.yep.Pojo.NavigationListPojo;
import project.books.com.yep.R;

public class MainActivity extends AppCompatActivity
         {

             ListView naviList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        BoilNaviMenu();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    private void BoilNaviMenu(){
        naviList = findViewById(R.id.navigation_list);

        List<NavigationListPojo> pojo = new ArrayList<>();
        pojo.add(new NavigationListPojo(R.drawable.ic_people_outline_black_24dp,"True Story"));
        pojo.add(new NavigationListPojo(R.drawable.ic_people_outline_black_24dp,"Success Story"));
        pojo.add(new NavigationListPojo(R.drawable.ic_people_outline_black_24dp,"Jokes"));
        pojo.add(new NavigationListPojo(R.drawable.ic_people_outline_black_24dp,"Science"));
        pojo.add(new NavigationListPojo(R.drawable.ic_people_outline_black_24dp,"Kids Story"));
        pojo.add(new NavigationListPojo(R.drawable.ic_people_outline_black_24dp,"Entertainment"));
        pojo.add(new NavigationListPojo(R.drawable.ic_people_outline_black_24dp,"Horror"));

        NavimenuListAdapter adapter = new NavimenuListAdapter(this,R.layout.custom_listview,pojo);

        naviList.setAdapter(adapter);

    }
}
