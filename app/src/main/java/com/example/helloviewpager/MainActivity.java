package com.example.helloviewpager;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RedFragment.OnFragmentInteractionListener, BlueFragment.OnFragmentInteractionListener, PinkFragment.OnFragmentInteractionListener {

    FragmentPagerAdapter adapterViewPager;
    ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpPager= findViewById(R.id.vpPager);

        adapterViewPager=new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri){
    }

    @Override
    public void onSwipeBlue() {
        int siguiente = vpPager.getCurrentItem() +1;
        vpPager.setCurrentItem(siguiente, true);
    }


    //
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return RedFragment.newInstance("", "");
                case 1:
                    return BlueFragment.newInstance("", "");
                case 2:
                    return PinkFragment.newInstance("", "");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "RED";
                case 1:
                    return "BLUE";
                case 2:
                    return "PINK";
                default:
                    return "TAB";
            }
        }

    }



 }