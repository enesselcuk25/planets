package com.enes.Egezegenler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        Thread timeThread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(splash_Activity.this,MainActivity.class));
                }

            }


        };
        timeThread.start();
    }
    public void onPause(){
        super.onPause();
        finish();
    }
}