package com.example.ubunto.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ubunto.View.SplachScreenFragments.DetailFragmentSplachScreen;
import com.example.ubunto.View.SplachScreenFragments.EndSplachScreen;
import com.example.ubunto.View.SplachScreenFragments.StartFragment;

public class VIewPagerAdapter extends FragmentStatePagerAdapter {
    public VIewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i==0)
            return new StartFragment();
        else if(i==1)
            return new DetailFragmentSplachScreen();

        else
            return new EndSplachScreen();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
