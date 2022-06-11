package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.HelperClass.InfoRozSt1;
import com.example.myapplication.HelperClass.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Stadia1 extends AppCompatActivity implements View.OnClickListener {
    TextView pl1na, pl2na, pl3na, pl4na, pl5na, pl6na, pl2st, pl3st, pl4st, pl5st, pl6st, balance;
    EditText setstavka;
    Button nedB, pas, bt_st;
    ImageView c1,c2,c3,c4,c5,c6;
    Player player;
    Boolean bt=true, bolned=true,bolp=false,bolpod=false;
    ArrayList<Bitmap> ned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadia1);
        player=Online_setName.player;
        ned=ned();
        init();
        locik();
    }
    private void init() {

        pl1na = findViewById(R.id.textView11);
        pl2na = findViewById(R.id.textView7);
        pl3na = findViewById(R.id.textView1);
        pl4na = findViewById(R.id.textView2);
        pl5na = findViewById(R.id.textView3);
        pl6na = findViewById(R.id.textView8);

        pl2st = findViewById(R.id.textView9);
        pl3st = findViewById(R.id.textView4);
        pl4st = findViewById(R.id.textView5);
        pl5st = findViewById(R.id.textView6);
        pl6st = findViewById(R.id.textView10);

        c1=findViewById(R.id.cart1);
        c2=findViewById(R.id.cart2);
        c3=findViewById(R.id.cart3);
        c4=findViewById(R.id.cart4);
        c5=findViewById(R.id.cart5);
        c6=findViewById(R.id.cart6);

        balance=findViewById(R.id.balance);
        setstavka = findViewById(R.id.edittext1);

        nedB = findViewById(R.id.nedcolB);
        pas = findViewById(R.id.pas);
        bt_st = findViewById(R.id.pods);

        pas.setOnClickListener(this);
        bt_st.setOnClickListener(this);
        nedB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nedcolB:
                if(bolned){
                    bolned=false;
                    otrCart(player.getNedCol());
                }else {
                    bolned=true;
                    otrCart(cart);
                }

                break;
            case R.id.pas:
                bt=false;
                bolp=true;
                break;
            case R.id.pods:
                bt=false;
                bolpod=true;
                break;
        }
    }
    ZaprosRet zp;
    ArrayList<InfoRozSt1> rasd;
    Integer backSt;
    ArrayList<Integer> cart;
    private void locik(){

        cart=new ArrayList<>();
        zp=new ZaprosRet();
        zp.setPlayer(player);
        Integer playIngame;
        for (int i = 0; i < player.getMaxPlayer(); i++) {
            playIngame=player.getMaxPlayer();
            for (int j = 0; j < player.getMaxPlayer(); j++) {
                cart.add(player.getNedCol().get(i*player.getMaxPlayer()+j));
            }
            Collections.sort(cart);
            while (playIngame>=1){
                rasd=zp.shitStadia1();
                backSt=zp.getBadSt();
                playIngame=proverca(playIngame);
                otr();
                if (playIngame==1) {
                    end();
                    break;
                }if(rasd.get(player.getNum()).getShod()){
                    myShod();
                }
            }
        }
    }

    private Integer proverca(Integer a){
        Integer lol=0;
        for(InfoRozSt1 s: rasd){
            if (s.getStavka()==0){
                lol++;
            }
        }
        if (lol>a){
            cart.remove(0);
            return lol;
        }
        return a;
    }

    private void otr(){
        for (int i = 0; i < player.getMaxPlayer(); i++) {
            if(i==player.getNum()){
                pl1na.setText(rasd.get(i).getName());
                balance.setText(player.getBalance());
                setstavka.setText(rasd.get(i).getStavka());
            }
                switch (i){
                    case 0:
                        pl2na.setText(rasd.get(i).getName());
                        pl2st.setText(rasd.get(i).getStavka());
                        break;
                    case 1:
                        pl3na.setText(rasd.get(i).getName());
                        pl3st.setText(rasd.get(i).getStavka());
                        break;
                    case 2:
                        pl4na.setText(rasd.get(i).getName());
                        pl4st.setText(rasd.get(i).getStavka());
                        break;
                    case 3:
                        pl5na.setText(rasd.get(i).getName());
                        pl5st.setText(rasd.get(i).getStavka());
                        break;
                    case 4:
                        pl6na.setText(rasd.get(i).getName());
                        pl6st.setText(rasd.get(i).getStavka());
                        break;
                    case 5:
                        pl1na.setText(rasd.get(i).getName());
                        setstavka.setText(rasd.get(i).getStavka());
                        break;
                }
            }
        otrCart(cart);
    }

    private void otrCart(ArrayList<Integer> a){
        for (int i = 0; i < cart.size(); i++) {
            switch (i){
                case 0:
                    c1.setImageBitmap(ned.get(a.get(i)));
                    break;
                case 1:
                    c2.setImageBitmap(ned.get(a.get(i)));
                    break;
                case 2:
                    c3.setImageBitmap(ned.get(a.get(i)));
                    break;
                case 3:
                    c4.setImageBitmap(ned.get(a.get(i)));
                    break;
                case 4:
                    c5.setImageBitmap(ned.get(a.get(i)));
                    break;
                case 5:
                    c6.setImageBitmap(ned.get(a.get(i)));
                    break;
            }
        }
    }

    private void myShod(){
        onClic();

        Toast.makeText(this, "Ваш ход", Toast.LENGTH_SHORT).show();
        while (bt){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bt=true;
        Integer a=Integer.valueOf(String.valueOf(setstavka.getText()));
        if (bolp){
            zp.otprMes("-5\n0");
            zp.otprMes("-6\n"+cart.get(0));
            cart.remove(0);
            player.setBalance(player.getBalance()-(player.getBackStavka()/2+player.getBackStavka()%2));
            player.setBalance(0);
        }else if (bolpod){
            if(backSt<a && player.getBalance()-a+player.getBackStavka()>=0){
                zp.otprMes("-5\n"+a);
                player.setBalance(player.getBalance()-(a-player.getBackStavka()));
                player.setBalance(a);
            }else {
                Toast.makeText(this, "Некорректные данные", Toast.LENGTH_SHORT).show();
            }

        }

        notClic();
    }

    private void onClic(){
        bt_st.setClickable(true);
        pas.setClickable(true);
    }

    private void notClic(){
        bt_st.setClickable(false);
        pas.setClickable(false);
    }


    private void end(){
        for (int i = 0; i < player.getMaxPlayer(); i++) {
            if(rasd.get(i).getShod()){
                Toast.makeText(this, "игру выйграл: "+rasd.get(i).getName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "новые карты", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }


    private ArrayList<Bitmap> ned() {
        ArrayList<Bitmap> c = new ArrayList<>();
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_1));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_2));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_3));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_4));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_6));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_7));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_8));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_9));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_10));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_11));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_12));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_13));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_14));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_15));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_16));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_17));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_18));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_19));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_20));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_21));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_22));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_23));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_24));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_25));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_26));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_27));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_28));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_29));
        c.add(BitmapFactory.decodeResource(getResources(), R.drawable.img_30));
        return c;
    }
}