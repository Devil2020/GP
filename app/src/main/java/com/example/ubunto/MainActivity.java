package com.example.ubunto;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.AutoScrollHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.ubunto.Adapter.VIewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private VIewPagerAdapter adapter;
    private DotsIndicator dotsIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotsIndicator=findViewById(R.id.DotIndicator);
        viewPager =findViewById(R.id.ViewPager);

        adapter=new VIewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        dotsIndicator.setViewPager(viewPager);
    }

    public void ClickRight(View view) {
        int position = viewPager.getCurrentItem();
        if (position == 0)
            viewPager.setCurrentItem(1);
        else if (position == 1)
            viewPager.setCurrentItem(2);
        else {
            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
        }
    }
}
