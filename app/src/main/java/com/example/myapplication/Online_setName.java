package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.HelperClass.Player;

public class Online_setName extends AppCompatActivity implements View.OnClickListener {
    Button goToPlay;
    RadioButton b1,b2,b3,b4;
    EditText name;
    Integer mp=3;
static Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_set_name);
        init();
    }

    private void init(){
        b1=findViewById(R.id.radio1);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.radio2);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.radio3);
        b3.setOnClickListener(this);
        b4=findViewById(R.id.radio4);
        b4.setOnClickListener(this);

        goToPlay=findViewById(R.id.button1);
        goToPlay.setOnClickListener(this);

        name=findViewById(R.id.edittext1);
        player=new Player();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                try {
                    player.setMaxPlayer(mp);
                    player.setName(String.valueOf(name.getText()));
                    Intent intent=new Intent(this, Ojidanie.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(this, "ага цас сломаюсь",Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.radio1:
                mp=3;
                break;
            case R.id.radio2:
                mp=4;
                break;
            case R.id.radio3:
                mp=5;
                break;
            case R.id.radio4:
                mp=6;
                break;

        }
    }
}