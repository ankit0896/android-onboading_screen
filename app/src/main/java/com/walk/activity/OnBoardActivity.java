package com.walk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.walk.R;
import com.walk.adapter.ViewPagerAdapter;
import com.walk.model.OnBoardItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnBoardActivity extends AppCompatActivity implements ViewPagerAdapter.OnBoardClickLisner, View.OnClickListener {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    ArrayList<OnBoardItem> list = new ArrayList<>();
    private int dotscount;
    private ViewPagerAdapter viewPagerAdapter;
    private ImageView[] dots;
    @BindView(R.id.slider_dots)
    LinearLayout sliderDots;
    int previous_pos = 0;
    @BindView(R.id.tv_term_conditions)
    TextView tnc;
    @BindView(R.id.card_view_get_started)
    CardView getStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        getStarted.setOnClickListener(this);
        loadData();
    }

    private void loadData() {
        list.add(new OnBoardItem(1, R.drawable.d1, "Hello Welcome To Practo", "", ""));
        list.add(new OnBoardItem(2, R.drawable.d2, "Keep Your Heart Healthy", "", ""));
        list.add(new OnBoardItem(3, R.drawable.d3, "24 X 7 Assistant ", "", ""));
        list.add(new OnBoardItem(4, R.drawable.d1, "Trouble singing in ?", "How we keep your data secure ?", "Enter Your Mobile Number"));
        setAdapter(list);
    }

    private void setAdapter(ArrayList<OnBoardItem> list) {
        viewPagerAdapter = new ViewPagerAdapter(this, list, OnBoardActivity.this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];
        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slider_non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDots.addView(dots[i], params);


        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slider_active_dot));
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < dotscount; i++) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slider_non_active_dot));

            }
            dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.slider_active_dot));

            if (position == dotscount - 1) {
                getStarted.setVisibility(View.INVISIBLE);
                tnc.setVisibility(View.VISIBLE);
            } else {
                getStarted.setVisibility(View.VISIBLE);
                tnc.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    @Override
    public void mobileNumberClickListner(int position) {
       startActivity(new Intent(OnBoardActivity.this,LoginMobileActivity.class));
    }

    @Override
    public void mobileDesc1ClickListner(int position) {
        if (list.size() == (position + 1)) {
            Toast.makeText(this, "Desc 1" + list.size() + " " + position, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void mobileDesc2ClickListner(int position) {
        if (list.size() == (position + 1)) {
            Toast.makeText(this, "Desc 2" + list.size() + " " + position, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v==getStarted){
            startActivity(new Intent(OnBoardActivity.this,LoginMobileActivity.class));
        }
    }
}