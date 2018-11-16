package com.example.daniel.tramas;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class ETH extends AppCompatActivity {
    private EditText et1,et2,et3,et4;
    private TextView tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eth);

        et1=(EditText)findViewById(R.id.txt_direccionDestino);
        et2=(EditText)findViewById(R.id.txt_direccionFuente);
        et3=(EditText)findViewById(R.id.txt_datos);
        et4=(EditText)findViewById(R.id.txt_crc);

        tv2=(TextView)findViewById(R.id.resultado_eth);
        tv3=(TextView)findViewById(R.id.textView_longitud);
        tv4=(TextView)findViewById(R.id.resultado_eth2);
    }
    //Casteo para pasar esos datos a un string
    public void enviarETH(View view2){
        String arr[];
        String preambulo="AAAAAAAAAAAAAA";
        String sof_string="AB";
        String direccionD_string=et1.getText().toString();
        String direccionF_string=et2.getText().toString();
        String longitud;
        String longitud_string;
        String datos_string=et3.getText().toString();
        String relleno_string;
        String crc_string=et4.getText().toString();

        //Casteo para asignar tipo de dato

        long crc_int=Long.parseLong(crc_string,2);


        //arreglo auxiliar
        arr=new String[datos_string.length()];

        for (int i = 0 ;i<datos_string.length();i++  ){
            //devuelve codo ascci de cada letra del arreglo
            //int tm =datos_string.codePointAt(i);
            //convierte el codigo hex
            arr[i]=Integer.toHexString(datos_string.codePointAt(i));;
        }
        datos_string= Arrays.toString(arr);
        datos_string=datos_string.replace(",","");
        datos_string=datos_string.replace("[","");
        datos_string=datos_string.replace("]","");

        //paso el int a string Hexadecimal
        String crc2= Long.toHexString(crc_int);

        //calculo de longitud:
        longitud=direccionD_string+direccionF_string+datos_string+crc2;
        longitud_string=Integer.toHexString(longitud.length());//ya tengo el dato en exadecimal del string
        String datos_string3= new String();
        relleno_string="";
        //**********Relleno a 46***************
        int tam=datos_string.length();

        if(tam<46){
            int aux= 46-(datos_string.length());
            //crendo el array con base al string
            char[] datos_array= new char[aux]; //datos_string.toCharArray();
            //llenar el array de basura

            for (int i =0;i<aux;i++){
                //relleno el arreglo de 0
                datos_array[i]='F';


            }
            //concateno el arreglo de basura al string auxiliar
            datos_string3=Arrays.toString(datos_array);
            datos_string3=datos_string3.replace(",","");
            datos_string3=datos_string3.replace("[","");
            datos_string3=datos_string3.replace("]","");
            relleno_string=datos_string3;


        } else  relleno_string=datos_string;




        String resultString= preambulo+""+sof_string+"DD: "+direccionD_string+"DF: "+direccionF_string+"Long:"+longitud_string+"Datos: "+datos_string;

        String resultString2="Relleno: "+relleno_string+""+" CRC:  "+crc2;

        //imprime

        tv2.setText(resultString);
        tv3.setText(longitud_string);
        tv4.setText(resultString2);



    }
    //metodo para regreso al menu

    public void Menu(View view){
        Intent menu= new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}
