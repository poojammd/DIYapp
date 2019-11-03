package com.example.pooja.diy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainintent=new Intent(Splashscreen.this,Login.class);
                startActivity(mainintent);
                finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}
