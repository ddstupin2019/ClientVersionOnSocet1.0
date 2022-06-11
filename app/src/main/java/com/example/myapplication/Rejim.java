package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Rejim extends AppCompatActivity implements View.OnClickListener {
    Button local, set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejim);
        Log.d("BY", "5");
        init();
    }
    public void init(){
        local=findViewById(R.id.local);
        local.setOnClickListener(this);

        set=findViewById(R.id.set);
        set.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.local:
                intent = new Intent(Rejim.this,Local_setname.class);
                startActivity(intent);
                break;
            case R.id.set:
                intent = new Intent(Rejim.this,Online_setName.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mosigra.ru/prodano/rules/"));
                startActivity(intent);
                break;

        }
    }
}