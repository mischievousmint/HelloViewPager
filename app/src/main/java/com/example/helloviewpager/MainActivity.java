package com.example.helloviewpager;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RedFragment.OnFragmentInteractionListener, BlueFragment.OnFragmentInteractionListener, PinkFragment.OnFragmentInteractionListener {

    FragmentPagerAdapter adapterViewPager;
    ViewPager vpPager;
    PagerTabStrip pageHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpPager= findViewById(R.id.vpPager);

        adapterViewPager=new MyPagerAdapter(getSupportFragmentManager());

        vpPager.setAdapter(adapterViewPager);

        pageHeader = findViewById(R.id.pager_header);
    }

    @Override
    public void onSwipeBlue() {
        int next = vpPager.getCurrentItem() +1;
        vpPager.setCurrentItem(next, true);
    }

    @Override
    public void onBackBlue() {
        int back = vpPager.getCurrentItem() -1;
        vpPager.setCurrentItem(back, true);
    }

    @Override
    public void onSwipeRed() {
        int next = vpPager.getCurrentItem() +1;
        vpPager.setCurrentItem(next, true);
    }

    @Override
    public void onBackPink() {
        int back = vpPager.getCurrentItem() -1;
        vpPager.setCurrentItem(back, true);
    }

/*    public void setBackground(String color) {
        switch (color) {
            case RED:
                pageHeader.setBackgroundColor(Color.RED);
                // pageHeader.setDrawFullUnderline(true);
                // pageHeader.setTabIndicatorColor(Color.RED);
            case BLUE:
                pageHeader.setBackgroundColor(Color.BLUE);;
            case PINK:
                pageHeader.setBackgroundColor("#FD7EF1");
            default:
                return "";
        }
    }*/


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