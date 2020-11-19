package com.walk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.walk.R;
import com.walk.model.OnBoardItem;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    ArrayList<OnBoardItem> onBoardItems = new ArrayList<>();
    OnBoardClickLisner onBoardClickLisner;

    public ViewPagerAdapter(Context context, ArrayList<OnBoardItem> onBoardItems, OnBoardClickLisner onBoardClickLisner) {
        this.context = context;
        this.onBoardItems = onBoardItems;
        this.onBoardClickLisner = onBoardClickLisner;
    }

    @Override
    public int getCount() {
        return onBoardItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = vi.inflate(R.layout.onboard_layout, null);
        TextView desc1, desc2, button;
        ImageView iv;
        OnBoardItem boardItem = onBoardItems.get(position);
        desc1 = view.findViewById(R.id.tv_title);
        desc2 = view.findViewById(R.id.tv_desc);
        button = view.findViewById(R.id.tv_button);
        iv = view.findViewById(R.id.iv_onboard);
        if (boardItem.getDesc2().isEmpty()) {
            desc2.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
        } else {
            desc2.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            desc2.setText(onBoardItems.get(position).getDesc2());
            button.setText(onBoardItems.get(position).getButton());
        }

        iv.setImageResource(onBoardItems.get(position).getImage());
        desc1.setText(onBoardItems.get(position).getDesc1());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBoardClickLisner.mobileNumberClickListner(position);
            }
        });
        desc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBoardClickLisner.mobileDesc1ClickListner(position);
            }
        });
        desc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBoardClickLisner.mobileDesc2ClickListner(position);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    public interface OnBoardClickLisner {
        void mobileNumberClickListner(int position);

        void mobileDesc1ClickListner(int position);

        void mobileDesc2ClickListner(int position);
    }
}
