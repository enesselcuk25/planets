package com.enes.Egezegenler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class kolay_testActivity extends AppCompatActivity {
private List<String> genelliste,sorulistesi;
private RelativeLayout soru_conteynır;
private LinearLayout buttonconteynır;
private TextView sayac,soru_tv;
private ImageView resim;
private String dogruCevap;
private Random random;
private int quiz;
private final int toplam_soru_sayisi = 10;
private Handler handler;
private int dogruCevapSayisi,toplamCevapSayisi,kacinciDenemede_bildi;
    private View.OnClickListener buttonDinliyecesi = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            toplamCevapSayisi++;
            Button button = (Button) view;
            String verilenCevap =button.getText().toString();

            if(verilenCevap.equals(dogruCevap)){

                kacinciDenemede_bildi = 1;
                buttonlarıEtkisizlestir();
                dogruCevapSayisi++;

                if(dogruCevapSayisi == toplam_soru_sayisi){

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog();
                        }
                    },1000);
                }
                else {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sonrakiSoru();
                        }
                    },1500);
                }
            }
            else {
                kacinciDenemede_bildi++;
                button.setEnabled(false);

            }

        }
    };

    private void dialog() {

        new AlertDialog.Builder(kolay_testActivity.this)
                .setTitle("Testi Bitirdiniz")
                .setMessage(getResources().getString(R.string.skor,toplamCevapSayisi,(float)(1000/toplamCevapSayisi)))
                .setPositiveButton("Bir Daha Dene", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetQuiz();
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Şimdilik Yeter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        dialogInterface.cancel();
                    }
                }).show();
    }

    private void buttonlarıEtkisizlestir() {
        for(int satir =0;satir<buttonconteynır.getChildCount();satir++){
            Button button = (Button) buttonconteynır.getChildAt(satir);
            button.setEnabled(false);
        }
    }

/*
    private void tebrikEt(int kacinciDenemede_bildi) {
        String tebrikmesaji = "";

        switch (kacinciDenemede_bildi){
            case 1: resim.setImageResource(R.drawable.dondurma); break;
            case 2: tebrikmesaji= "iyisin";break;
            case 3: tebrikmesaji ="Fena değil"; break;
            case 4: tebrikmesaji ="çalışda gel"; break;
        }
        soru_tv.setText(tebrikmesaji);
        resim.setImageResource(Integer.parseInt(tebrikmesaji));

        soru_tv.setTextColor(Color.RED);
        soru_tv.setTextSize(40);
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolay_test);

        quiz = getIntent().getIntExtra(testler.quiz_key,testler.kolay);


        soru_conteynır = findViewById(R.id.soru_conteynır);
        buttonconteynır = findViewById(R.id.buton_container);
        sayac = findViewById(R.id.sayac);
        soru_tv = findViewById(R.id.soru_tv);
        resim = findViewById(R.id.resim);


        handler = new Handler();
        genelliste = new ArrayList<String>();
        sorulistesi = new ArrayList<String>();
        random = new Random();
        kacinciDenemede_bildi = 1;

        for (int satir =0;satir<buttonconteynır.getChildCount();satir++){
            Button button = (Button) buttonconteynır.getChildAt(satir);
            button.setOnClickListener(buttonDinliyecesi);
        }
        sayac.setText("1 / "+toplam_soru_sayisi);



        switch (quiz){
            case testler.kolay:
                soru_tv.setTextSize(20);
                String[] dizi = getResources().getStringArray(R.array.kolayTestler);
                for(String s: dizi){
                    genelliste.add(s);
                }

                break;
            case testler.orta:
                soru_tv.setTextSize(20);
                String[] dizi1 = getResources().getStringArray(R.array.ortatestler);
                for(String s: dizi1){
                    genelliste.add(s);
                }
                break;
            case testler.zor:
                soru_tv.setTextSize(20);
                String[] dizi2 = getResources().getStringArray(R.array.zortestler);
                for(String s: dizi2){
                    genelliste.add(s);
                }
                break;
        }
        resetQuiz();

    }

    private void resetQuiz() {
         toplamCevapSayisi =0;
         dogruCevapSayisi =0;

        sorulistesi.clear();

        int soruSayisi =1;
        int listedekiElamanSayisi = genelliste.size();

        while (soruSayisi <= toplam_soru_sayisi){
            int index = random.nextInt(listedekiElamanSayisi);
            String soru = genelliste.get(index);

            if(!sorulistesi.contains(soru)){
                sorulistesi.add(soru);
                soruSayisi++;
            }
        }
        sonrakiSoru();

    }

    private void sonrakiSoru() {

       if(quiz == testler.kolay){
           soru_tv.setTextSize(20);
       }
       else if(quiz == testler.orta){
            soru_tv.setTextSize(20);
        }
       else if(quiz == testler.zor){
            soru_tv.setTextSize(20);
        }
        soru_tv.setTextColor(Color.parseColor("#FFFFFF"));
        sayac.setText(dogruCevapSayisi+1 +" / "+toplam_soru_sayisi);

        String soru = sorulistesi.remove(0);
        soru_tv.setText(getSoru(soru));
        dogruCevap =getCevap(soru);

        Collections.shuffle(genelliste);
        int dogruCevapIndex = genelliste.indexOf(soru);

        genelliste.add(genelliste.remove(dogruCevapIndex));

        for (int satir =0;satir<buttonconteynır.getChildCount();satir++){
            Button button = (Button) buttonconteynır.getChildAt(satir);

            String secenek = genelliste.get(satir);
            button.setText(getCevap(secenek));
            button.setEnabled(true);
        }

        int rastgeleIndex = random.nextInt(4);
        ((Button) buttonconteynır.getChildAt(rastgeleIndex)).setText(dogruCevap);


    }

    private String getSoru(String soru) {

        soru=soru.substring(0,soru.indexOf("-"));
        return soru;
    }

    // - işaretinden sonrasını kesip alıyoruz.
    private String getCevap(String soru) {
        soru=soru.substring(soru.indexOf("-")+1,soru.length());
        return soru;
    }
}