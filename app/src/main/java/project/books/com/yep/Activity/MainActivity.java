package project.books.com.yep.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.pixplicity.multiviewpager.MultiViewPager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import project.books.com.yep.Adapter.NavimenuListAdapter;
import project.books.com.yep.Adapter.ViewPagerAdapter;
import project.books.com.yep.Fragment.PagerFragment;
import project.books.com.yep.Pojo.FragmentPopulatePojo;
import project.books.com.yep.Pojo.NavigationListPojo;
import project.books.com.yep.R;
import project.books.com.yep.Utility.PagerTransformer;

public class MainActivity extends AppCompatActivity
         {

             TextView mainTitle;
             MultiViewPager viewPager;
             ListView naviList;
             CircleIndicator indicator;
             ViewPagerAdapter adapter;

             //timer
             int ci=0;

             //badge layout
            public RelativeLayout badgeLayout;
             TextView view1;
             int count = 1;

             ImageView facebook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        badgeLayout = findViewById(R.id.badge_layout3);
        facebook = findViewById(R.id.facebook);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        BoilNaviMenu();
        BoilViewPager();
        ViewPagerScrolling();

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
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item1 = menu.findItem(R.id.actionbar_item);
        MenuItemCompat.setActionView(item1, R.layout.update_noticiation_count);
        badgeLayout = (RelativeLayout) MenuItemCompat.getActionView(item1);
       Button button = badgeLayout.findViewById(R.id.button3);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getApplicationContext(), "notification showed", Toast.LENGTH_SHORT).show();
               count = 0;
               view1.setText(String.format("%d",count));
           }
       });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id==R.id.actionbar_item){


        }

        return super.onOptionsItemSelected(item);
    }

    private void BoilNaviMenu(){
        naviList = findViewById(R.id.navigation_list);

        List<NavigationListPojo> pojo = new ArrayList<>();
        pojo.add(new NavigationListPojo(R.drawable.true_story,"True Story"));
        pojo.add(new NavigationListPojo(R.drawable.success_story,"Success Story"));
        pojo.add(new NavigationListPojo(R.drawable.jokes,"Jokes"));
        pojo.add(new NavigationListPojo(R.drawable.science,"Science"));
        pojo.add(new NavigationListPojo(R.drawable.kid_story,"Kids Story"));
        pojo.add(new NavigationListPojo(R.drawable.entiretenment,"Entertainment"));
        pojo.add(new NavigationListPojo(R.drawable.horror,"Horror"));
        pojo.add(new NavigationListPojo(R.drawable.advanture,"Advanture"));
        pojo.add(new NavigationListPojo(R.drawable.mistry,"Mistry"));
        NavimenuListAdapter adapter = new NavimenuListAdapter(this,R.layout.custom_listview,pojo);

        naviList.setAdapter(adapter);
    }

    private void BoilViewPager(){

        viewPager = findViewById(R.id.pager);
        indicator = findViewById(R.id.indicator);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", (Serializable) new FragmentPopulatePojo("True Story", R.drawable.cloudy));
        Fragment trueStory = new PagerFragment();
        trueStory.setArguments(bundle);


        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("data", (Serializable) new FragmentPopulatePojo("Hot Story", R.drawable.hotsun));
        Fragment HotStory = new PagerFragment();
        HotStory.setArguments(bundle1);

        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("data", (Serializable) new FragmentPopulatePojo("Advanture", R.drawable.raining));
        Fragment Adventure = new PagerFragment();
        Adventure.setArguments(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putSerializable("data", (Serializable) new FragmentPopulatePojo("Horror Story", R.drawable.morning_sun));
        Fragment horror = new PagerFragment();
        horror.setArguments(bundle3);






        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        adapter.addFragment(trueStory);
        adapter.addFragment(HotStory);
        adapter.addFragment(Adventure);
        adapter.addFragment(horror);
       adapter.notifyDataSetChanged();
        indicator.setViewPager(viewPager);
        adapter.registerDataSetObserver(indicator.getDataSetObserver());
        viewPager.setPageTransformer(true,new PagerTransformer());

        mainTitle = findViewById(R.id.mainTitle);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Bundle bundle = adapter.getItem(position).getArguments();
                FragmentPopulatePojo locationPojo = (FragmentPopulatePojo) bundle.getSerializable("data");
                if (locationPojo != null) {
                    mainTitle.setText(locationPojo.getTitle());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        //atuo scrolling
         ci = 0;
        java.util.Timer timer;
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                viewPager.post(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem(ci % adapter.getCount(),true);
                        ci++;
                    }
                });
            }
        },2000,3000);
    }


private void ViewPagerScrolling(){

}


  public void onFacebook(View view) {
     view1 = badgeLayout.findViewById(R.id.badge_notification);
    view1.setText(String.format("%d",count++));

             }

             public void onTwitter(View view) {
                Intent in = new Intent(this, Catagory.class);
                startActivity(in);
             }
         }
