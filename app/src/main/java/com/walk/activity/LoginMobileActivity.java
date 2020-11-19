package com.walk.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;
import com.walk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginMobileActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.et_login_mobile_number)
    EditText mobileNumber;
    @BindView(R.id.card_login_continue)
    CardView login_continue;
    @BindView(R.id.iv_login_back)
    ImageView back;
    @BindView(R.id.tv_login_help)
    TextView help;

    @BindView(R.id.cl_login_mobile)
    ConstraintLayout constraintLayout;
    @BindView(R.id.tv_91) TextView selectCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mobile);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                login_continue.setAlpha(0.5F);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length()<10){
                        login_continue.setAlpha(0.5F);
                    }else{
                        login_continue.setAlpha(1);
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        /*
        Click Events
         */
        clickEvents();
    }

    private void clickEvents() {
        back.setOnClickListener(this);
        login_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==back){
            onBackPressed();
        }
        if(v==help){
            //TODO
        }
        if(v==login_continue){
            if(validateNumber()){
                Toast.makeText(this, "Ready To Go", Toast.LENGTH_SHORT).show();
            }
        }
        if(v==selectCountry){
            // TODO
        }
    }

    private boolean validateNumber() {
        if(mobileNumber.getText().toString().isEmpty()){
            Snackbar.make(constraintLayout, "Please Enter Your Mobile Number", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return false;
        }
        if(mobileNumber.getText().toString().length()<10){
            Snackbar.make(constraintLayout, "Please Enter Valid Mobile Number", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return false;
        }
        return true;
    }
}