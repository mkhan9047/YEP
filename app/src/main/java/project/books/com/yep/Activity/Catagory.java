package project.books.com.yep.Activity;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import project.books.com.yep.Adapter.CatagoryListAdapter;
import project.books.com.yep.Fragment.Horror;
import project.books.com.yep.Pojo.NavigationListPojo;
import project.books.com.yep.R;

public class Catagory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.coltool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Fragment newFragment = new Horror();
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.custom_frame, newFragment).commit();



    }
}
