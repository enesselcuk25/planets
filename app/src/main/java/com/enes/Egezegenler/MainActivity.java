package com.enes.Egezegenler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper v_filipper;
    private Button gokcisim,testlerr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v_filipper = findViewById(R.id.v_filipper);
        gokcisim = findViewById(R.id.gokcisimleri);
        testlerr= findViewById(R.id.testler);

        // animasyon = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.buttonbuyumesi);
        //  gokcisim.setAnimation(animasyon);
        // testlerr.setAnimation(animasyon);


        gokcisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, gokcisimleriActivity.class));
            }
        });
        testlerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, testler.class));
            }
        });





        int image[] = {R.drawable.jjupiter,R.drawable.mmars,R.drawable.mmerkur,R.drawable.nneptun,R.drawable.ssaturn,R.drawable.uuranus,R.drawable.vvenus,R.drawable.dunyaa};

        for(int i=0;i<image.length;i++){
            flipperimage(image[i]);

        }

        for(int images: image){
            flipperimage(images);
        }


    }
    public void flipperimage(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_filipper.addView(imageView);
        v_filipper.setFlipInterval(4000);
        v_filipper.setAutoStart(true);

        v_filipper.setOutAnimation(this,android.R.anim.slide_out_right);
        v_filipper.setInAnimation(this,android.R.anim.slide_in_left);


    }
}