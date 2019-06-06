package com.example.daniel.tramas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Método para el botón bsc
    public void SaltoBsc(View view){
        Intent bsc_salto = new Intent(this, BSC.class);
        startActivity(bsc_salto);
    }   //Método para el botón hdlc
    public void SaltoHdlc(View view){
        Intent hdlc_salto = new Intent(this, HDLC.class);
        startActivity(hdlc_salto);
    }
    public void SaltoPPP(View view){
        Intent ppp_salto = new Intent(this, PPP.class);
        startActivity(ppp_salto);
    }
    public void SaltoETH(View view){
        Intent eth_salto = new Intent(this, ETH.class);
        startActivity(eth_salto);
    }
    public void Salto2ETH(View view){
        Intent ethSalto=new Intent(this, ETH.class);
        startActivity(ethSalto);

    }
    public void SaltoWifi(View view){
        Intent wifiSalto=new Intent(this, WIFI.class);
        startActivity(wifiSalto);

    }




}
