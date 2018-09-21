package app.sporcial.pos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import app.sporcial.pos.R;
import app.sporcial.pos.fragments.Event_Fragment;
import app.sporcial.pos.fragments.Favorite_Fragment;
import app.sporcial.pos.fragments.Home_Fragment_Slider;
import app.sporcial.pos.fragments.Profile_Fragment_Slider;
import app.sporcial.pos.fragments.Search_Fragment;
import app.sporcial.pos.fragments.Search_fragment_Slider;
import app.sporcial.pos.fragments.home_fragment;

public class FirstPageActivity extends AppCompatActivity
    implements BottomNavigationView.OnNavigationItemSelectedListener,NavigationView.OnNavigationItemSelectedListener
{
    private static final String TAG = FirstPageActivity.class.getSimpleName();
    BottomNavigationView bottom;
    ImageButton ib;
    DrawerLayout dl;
    NavigationView nv;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage_layout);

        loadFragment(new home_fragment());
//        loadFragment(new Home_Fragment_Slider());

        selectFragment(R.id.navigation_home);
       if (savedInstanceState == null) {
           loadFragment(new Home_Fragment_Slider());
        }

        bottom=findViewById(R.id.bottom_navigation);
        bottom.setOnNavigationItemSelectedListener(this);

        ib = findViewById(R.id.ib_navigation);
        dl = findViewById(R.id.drawer);
        nv = findViewById(R.id.navi_view);

       nv.setNavigationItemSelectedListener(this);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.openDrawer(Gravity.LEFT);
            }
        });


    }

    public void selectFragment(int id)
    {
        Fragment fragment = null;
        switch(id)
        {
            case R.id.navigation_home:
                //Log.d(TAG,"click on home navigation view");
                fragment = new Home_Fragment_Slider();
                break;

            case R.id.navigation_search:
                fragment = new Search_fragment_Slider();
                break;

            case R.id.navigation_event:
                fragment = new Event_Fragment();
                break;

            case R.id.navigation_profile:
                fragment = new Profile_Fragment_Slider();
                break;

        }

        if(fragment!=null)
        {
            FragmentTransaction ft= getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,fragment);
            ft.commit();

        }
        dl = findViewById(R.id.drawer);
        dl.closeDrawer(GravityCompat.START);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_list, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.navigation_home) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG,"click on home navigation view");
        Fragment fragment = null;

            switch (item.getItemId())
            {
                case R.id.home:
                     fragment = new home_fragment();
                     break;

                case R.id.search:
                     fragment = new Search_Fragment();
                     break;

                case R.id.event:
                     fragment = new Event_Fragment();
                     break;

                case R.id.fav:
                     fragment = new Favorite_Fragment();
                     break;

                case R.id.navigation_home:
                    Log.d(TAG,"click on home navigation view");
                    fragment = new Home_Fragment_Slider();
                    break;

                case R.id.navigation_search:
                    fragment = new Search_fragment_Slider();
                    break;

                case R.id.navigation_event:
                    fragment = new Event_Fragment();
                    break;

                case R.id.navigation_profile:
                    fragment = new Profile_Fragment_Slider();
                    break;
            }
//
            dl.closeDrawer(GravityCompat.START);
//            item.setChecked(true);
           // selectFragment(item.getItemId());
            return loadFragment(fragment);

    }

//    @Override
//    public void onBackPressed() {
//        if(dl.isDrawerOpen(GravityCompat.START))
//        {
//            dl.closeDrawer(GravityCompat.START);
//        }else {
//            super.onBackPressed();
//        }
//    }

    private boolean loadFragment(Fragment fragment)
    {

        if(fragment!= null)
        {
             getSupportFragmentManager()
                     .beginTransaction()
                     .replace(R.id.container,fragment)
                     .commit();

                selectFragment(fragment.getId());
                return  true;
        }
        return false;

    }
}
