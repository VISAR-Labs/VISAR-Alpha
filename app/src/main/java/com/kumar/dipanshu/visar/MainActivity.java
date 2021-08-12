package com.kumar.dipanshu.visar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.kumar.dipanshu.visar.Fragments.ContentFragment;
import com.kumar.dipanshu.visar.Fragments.FifthMenuFragment;
import com.kumar.dipanshu.visar.Fragments.FirstMenuFragment;
import com.kumar.dipanshu.visar.Fragments.FourthMenuFragment;
import com.kumar.dipanshu.visar.Fragments.SecondMenuFragment;
import com.kumar.dipanshu.visar.Fragments.SixthMenuFragment;
import com.kumar.dipanshu.visar.Fragments.ThirdMenuFragment;
import com.kumar.dipanshu.visar.ResideTransformation.CornerReside;
import com.kumar.dipanshu.visar.ResideTransformation.HorizontalReside;
import com.kumar.dipanshu.visar.ResideTransformation.VerticalReside;

public class MainActivity extends AppCompatActivity implements DrawerLocker{

    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;
    Intent intent;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewpager);

        //setting fragment pager adapter
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());


        intent = getIntent();
        String option = intent.getStringExtra(Constant.OPTION);

        switch (option) {
            case Constant.HORIZONTAL_RESIDE:
                //adding fragments for Horizontal Reside menu
                myPagerAdapter.addFragments(new FirstMenuFragment());
                myPagerAdapter.addFragments(new ContentFragment());
                myPagerAdapter.addFragments(new SecondMenuFragment());

                viewPager.setPageTransformer(true, new HorizontalReside());
                break;
            case Constant.VERTICAL_RESIDE:
                //adding fragments for Vertical Reside menu
                myPagerAdapter.addFragments(new ThirdMenuFragment());
                myPagerAdapter.addFragments(new ContentFragment());
                myPagerAdapter.addFragments(new FourthMenuFragment());

                viewPager.setPageTransformer(true, new VerticalReside());
                break;
            case Constant.CORNER_RESIDE:
                //adding fragments for Vertical Reside menu
                myPagerAdapter.addFragments(new FifthMenuFragment());
                myPagerAdapter.addFragments(new ContentFragment());
                myPagerAdapter.addFragments(new SixthMenuFragment());

                viewPager.setPageTransformer(true, new CornerReside());
                break;
        }

        //set adapter to vewpager instance
        viewPager.setAdapter(myPagerAdapter);

        viewPager.setCurrentItem(1);    //page shown to user when he opened the app
    }


    //method called when user clicked on menu fragment layouts
    public void showPage(View view){
        viewPager.setCurrentItem(1);
    }

    @Override
    public void setDrawerEnabled(boolean enabled) {
    int lockMode = enabled ? DrawerLayout.LOCK_MODE_UNLOCKED:
                            DrawerLayout.LOCK_MODE_LOCKED_CLOSED;
    drawer.setDrawerLockMode(lockMode);
    toggle.setDrawerIndicatorEnabled(enabled);
    }
}

