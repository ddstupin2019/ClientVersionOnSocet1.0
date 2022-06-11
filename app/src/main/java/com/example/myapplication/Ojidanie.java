package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.myapplication.HelperClass.Player;

public class Ojidanie extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ojidanie);
        ZaprosRet zn=new ZaprosRet();
        zn.setPlayer(Online_setName.player);
        zn.setDan();
        Online_setName.player=zn.getPlayer();
    }
}