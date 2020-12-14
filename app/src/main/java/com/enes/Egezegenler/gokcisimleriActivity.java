package com.enes.Egezegenler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.enes.Egezegenler.gezegenbilgileri.dunyaActivity;
import com.enes.Egezegenler.gezegenbilgileri.jupiterActivity;
import com.enes.Egezegenler.gezegenbilgileri.marsActivity;
import com.enes.Egezegenler.gezegenbilgileri.merkurActivity;
import com.enes.Egezegenler.gezegenbilgileri.neptunActivity;
import com.enes.Egezegenler.gezegenbilgileri.potunActivity;
import com.enes.Egezegenler.gezegenbilgileri.saturnActivity;
import com.enes.Egezegenler.gezegenbilgileri.uranusActivity;
import com.enes.Egezegenler.gezegenbilgileri.venusActivity;

public class gokcisimleriActivity extends AppCompatActivity {
    private CardView cardViewmerkur,cardViewvenus,cardViewdunya,cardViewmars,cardViewjupiter,cardViewsaturn,cardViewuranus,cardViewneptun,cardViewplotun;
    private ImageView merkur,venus,dunya,mars,jupiter,saturn,uranus,neptun,plotun;
    private Animation buttonkaydir,venuss,dunyas,marss,jupiterr,saturnn,uranuss,neptunn,plotunn,yazi;
    private TextView merkuur,venuus,dunyya,marrs,jupiteer,saturrn,uranuus,neptuun,plotuun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gokcisimleri);

        gezegenler();
        cardview();
    }
    private void gezegenler() {

        cardViewmerkur= findViewById(R.id.cardviewmerkur);
        cardViewvenus= findViewById(R.id.cardViewvenus);
        cardViewdunya= findViewById(R.id.cardViewdunya);
        cardViewmars= findViewById(R.id.cardViewmars);
        cardViewjupiter= findViewById(R.id.cardViewjupiter);
        cardViewsaturn= findViewById(R.id.cardViewsaturn);
        cardViewuranus= findViewById(R.id.cardViewuranus);
        cardViewneptun= findViewById(R.id.cardViewneptun);
        cardViewplotun= findViewById(R.id.cardViewplatun);

        merkur = findViewById(R.id.merkur);
        venus = findViewById(R.id.venus);
        dunya = findViewById(R.id.dunya);
        mars = findViewById(R.id.mars);
        jupiter = findViewById(R.id.jupiter);
        saturn = findViewById(R.id.saturn);
        uranus = findViewById(R.id.uranus);
        neptun = findViewById(R.id.neptun);
        plotun = findViewById(R.id.plotun);

        merkuur = findViewById(R.id.merkuur);
        venuus = findViewById(R.id.venuus);
        dunyya = findViewById(R.id.dunyya);
        marrs = findViewById(R.id.marrs);
        jupiteer = findViewById(R.id.jupiteer);
        saturrn = findViewById(R.id.saturrn);
        uranuus = findViewById(R.id.uranuus);
        neptuun= findViewById(R.id.neptuun);
        plotuun = findViewById(R.id.plotuun);

        yazi = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.yazi);

        merkuur.setAnimation(yazi);
        venuus.setAnimation(yazi);
        dunyya.setAnimation(yazi);
        marrs.setAnimation(yazi);
        jupiteer.setAnimation(yazi);
        saturrn.setAnimation(yazi);
        uranuus.setAnimation(yazi);
        neptuun.setAnimation(yazi);
        plotuun.setAnimation(yazi);







        buttonkaydir = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.buttonkaydir);
        venuss = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.venus);
        dunyas = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.dunya);
        marss = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mars);
        jupiterr = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.jupiter);
        saturnn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.saturn);
        uranuss = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.uranus);
        neptunn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.neptun);
        plotunn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.plotun);




        merkur.setAnimation(buttonkaydir);
        venus.setAnimation(venuss);
        dunya.setAnimation(dunyas);
        mars.setAnimation(marss);
        jupiter.setAnimation(jupiterr);
        saturn.setAnimation(saturnn);
        uranus.setAnimation(uranuss);
        neptun.setAnimation(neptunn);
        plotun.setAnimation(plotunn);



    }
    public void cardview(){
        cardViewmerkur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gokcisimleriActivity.this, merkurActivity.class));
            }
        });

        cardViewvenus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gokcisimleriActivity.this, venusActivity.class));
            }
        });
        cardViewdunya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gokcisimleriActivity.this, dunyaActivity.class));
            }
        });
        cardViewmars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gokcisimleriActivity.this, marsActivity.class));
            }
        });
        cardViewjupiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gokcisimleriActivity.this, jupiterActivity.class));
            }
        });
        cardViewsaturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gokcisimleriActivity.this, saturnActivity.class));
            }
        });
        cardViewuranus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gokcisimleriActivity.this, uranusActivity.class));
            }
        });
        cardViewneptun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gokcisimleriActivity.this, neptunActivity.class));
            }
        });
        cardViewplotun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gokcisimleriActivity.this, potunActivity.class));
            }
        });


    }
}