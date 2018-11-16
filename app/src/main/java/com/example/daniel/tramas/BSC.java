package com.example.daniel.tramas;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class BSC extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5,et6,et7;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsc);

        et1=(EditText)findViewById(R.id.txt_sync);
        et2=(EditText)findViewById(R.id.txt_soh);
        et3=(EditText)findViewById(R.id.txt_cabecera);
        et4=(EditText)findViewById(R.id.txt_stx);
        et5=(EditText)findViewById(R.id.txt_textoBsc);
        et6=(EditText)findViewById(R.id.txt_etx);
        et7=(EditText)findViewById(R.id.txt_crc);
        tv2=(TextView)findViewById(R.id.resultado_bsc);
    }
    //Casteo para pasar esos datos a un string
    public void enviarBSC2(View view2){
        String arr[];


        String sync_string=et1.getText().toString();
        String soh_string=et2.getText().toString();
        String cabecera_string=et3.getText().toString();
        String stx_string=et4.getText().toString();
        String texto_string=et5.getText().toString();
        String etx_string=et6.getText().toString();
        String crc_string=et7.getText().toString();
        //Casteo para asignar tipo de dato

        int sync_int=Integer.parseInt(sync_string, 2);
        int soh_int=Integer.parseInt(soh_string, 2);
        int cabecera_int=Integer.parseInt(cabecera_string, 2);
        int stx_int=Integer.parseInt(stx_string, 2);

        int etx_int=Integer.parseInt(etx_string, 2);
        long crc_int=Long.parseLong(crc_string,2);

        //arreglo auxiliar
        arr=new String[texto_string.length()];

        for (int i = 0 ;i<texto_string.length();i++  ){
            //devuelve codo ascci de cada letra del arreglo
            //int tm =texto_string.codePointAt(i);
            //convierte el codigo hex
            arr[i]=Integer.toHexString(texto_string.codePointAt(i));;
        }
        texto_string= Arrays.toString(arr);
        texto_string=texto_string.replace(",","");
        texto_string=texto_string.replace("[","");
        texto_string=texto_string.replace("]","");

        //paso el int a string Hexadecimal
        String sync= Integer.toHexString(sync_int);
        String soh= Integer.toHexString(soh_int);
        String cabecera= Integer.toHexString(cabecera_int);
        String stx= Integer.toHexString(stx_int);
        String etx= Integer.toHexString(etx_int);
        String crc2= Long.toHexString(crc_int);

        //concatena


        String resultString= sync+" "+soh+" "+cabecera+" "+stx+" "+texto_string+" "+etx+" "+crc2;



        //imprime

        tv2.setText(resultString);



    }
    //metodo para regreso al menu

    public void Menu(View view){
        Intent menu= new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}
