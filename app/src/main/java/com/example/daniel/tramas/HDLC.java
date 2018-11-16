package com.example.daniel.tramas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class HDLC extends AppCompatActivity {
    private EditText et1,et2,et3,et4;
    private TextView tv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hdlc);
        //Casteo para sacar el dato del txt
        et1=(EditText)findViewById(R.id.txt_direccion);
        et2=(EditText)findViewById(R.id.txt_control);
        et3=(EditText)findViewById(R.id.txt_textoHdlc);
        et4=(EditText)findViewById(R.id.txt_crc);
        tv1=(TextView)findViewById(R.id.resultado_hdlc);


    }
    //Casteo para pasar esos datos a un string


    public void enviarHDLC(View view){
        String arr[];

        String direccion_string=et1.getText().toString();
        String control_string=et2.getText().toString();
        String texto_string=et3.getText().toString();
        String crc_string=et4.getText().toString();
        //Casteo para asignar tipo de dato

        int direccion_int=Integer.parseInt(direccion_string, 2);
        int control_int=Integer.parseInt(control_string, 2);
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
        String direccion= Integer.toHexString(direccion_int);
        String control= Integer.toHexString(control_int);
        String crc2= Long.toHexString(crc_int);

        //concatena


        String resultString= "7E"+direccion+" "+control+" "+texto_string+" "+" "+crc2+"7E";


        //imprime

        tv1.setText(resultString);



    }




    //metodo para regreso al menu

    public void Menu(View view){
        Intent menu= new Intent(this, MainActivity.class);
        startActivity(menu);
    }

}
