package com.example.daniel.tramas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class WIFI extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5,et6,et7,et8,et9;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        //Casteo para sacar el dato del txt
        et1=(EditText)findViewById(R.id.txt_duracion);
        et2=(EditText)findViewById(R.id.txt_mac1);
        et3=(EditText)findViewById(R.id.txt_mac2);
        et4=(EditText)findViewById(R.id.txt_mac3);
        et5=(EditText)findViewById(R.id.txt_control);
        et6=(EditText)findViewById(R.id.txt_secuencia);
        et7=(EditText)findViewById(R.id.txt_datos);
        et8=(EditText)findViewById(R.id.txt_mac4);
        et9=(EditText)findViewById(R.id.txt_crc);
        tv1=(TextView)findViewById(R.id.wifi);


    }

    public void enviarWIFI(View view){
        String arr[];

        String direccion_string=et1.getText().toString();
        String control_string=et2.getText().toString();
        String texto_string=et3.getText().toString();
        String crc_string=et4.getText().toString();
        String protocolo_string="";

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


        String resultString= "7E"+direccion+" "+control+" "+protocolo_string+" "+texto_string+" "+" "+crc2+"7E";


        //imprime

        tv1.setText(resultString);



    }






    public void Menu(View view){
        Intent menu= new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}
