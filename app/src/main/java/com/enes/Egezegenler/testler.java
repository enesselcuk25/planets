package com.enes.Egezegenler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class testler extends AppCompatActivity {
    public static final String quiz_key = "key";
    public static final int kolay = 1;
    public static final int orta = 2;
    public static final int zor = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testler);
    }

    public void textClick(View view){
        Intent inten = new Intent(getApplicationContext(),kolay_testActivity.class);

        switch (view.getId()){
            case R.id.fab1:
                inten.putExtra(quiz_key,kolay);
                startActivity(inten);
                break;
            case R.id.fab2:
                inten.putExtra(quiz_key,orta);
                startActivity(inten);
                break;
            case R.id.fab3:
                inten.putExtra(quiz_key,zor);
                startActivity(inten);
                break;


        }
    }
}