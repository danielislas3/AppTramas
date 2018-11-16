package com.example.daniel.tramas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class PPP extends AppCompatActivity {
    private EditText et1,et2,et3,et4;
    private TextView tv1;
    private Spinner spinner1;
    //private static final String[] paths = {"item 1", "item 2", "item 3"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppp);
        //Casteo para sacar el dato del txt
        et1=(EditText)findViewById(R.id.txt_direccion);
        et2=(EditText)findViewById(R.id.txt_control);
        et3=(EditText)findViewById(R.id.txt_textoPpp);
        et4=(EditText)findViewById(R.id.txt_crc);
        tv1=(TextView)findViewById(R.id.ppp);
        spinner1=(Spinner)findViewById(R.id.protocolo);

        //spiner
        String []protocolos ={"Reservado","IP","OSI","Xerox","DECnet","Appletalk","Novell IPX", "Luxcom","Sigma Network System",
                "IP Control Protocol","OSI Control Protocol","Xerox Control Protocol", "DECnet Control Protocol", "Appletalk Control Protocol",
                "Novell IPX Control Protocol", "Link Control Protocol","PAP", "CHAP"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,protocolos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item_protocolo,protocolos);
        spinner1.setPrompt("Select an item");
        adapter.setDropDownViewResource(R.layout.spinner_item_protocolo);
        spinner1.setAdapter(adapter);



    }
    //metodo del boton



    public void enviarPPP(View view){
        String arr[];

        String direccion_string=et1.getText().toString();
        String control_string=et2.getText().toString();
        String texto_string=et3.getText().toString();
        String crc_string=et4.getText().toString();
        String protocolo_string="";
        //guarda el dato de spinner en un array
        String seleccion=spinner1.getSelectedItem().toString();
        switch (seleccion){
            case "Reservado":
                    protocolo_string="0001";
                break;
                case "IP":
                    protocolo_string="0021";
                break;
                case "OSI":
                    protocolo_string="0023";
                break;
                case "Xerox":
                    protocolo_string="0025";
                break;
                case "DECnet":
                    protocolo_string="0027";
                break;
                case "Appletalk":
                    protocolo_string="0029";
                break;
                case "Novell IPX":
                    protocolo_string="002B";
                break;
                case "Luxcom":
                    protocolo_string="0231";
                break;
                case "Sigma Network System":
                    protocolo_string="0233";
                break;
                //

            case "IP Control Protocol":
                protocolo_string="8021";
                break;
            case "OSI Control Protocol":
                protocolo_string="8023";
                break;
            case "Xerox Control Protocol":
                protocolo_string="8025";
                break;
            case "DECnet Control Protocol":
                protocolo_string="8027";
                break;
            case "Appletalk Control Protocol":
                protocolo_string="8029";
                break;
            case "Novell IPX Control Protocol":
                protocolo_string="802B";
                break;
            case "Link Control Protocol":
                protocolo_string="C021";
                break;
            case "PAP":
                protocolo_string="C023";
                break;
                case "CHAP":
                protocolo_string="C223";
                break;



          //  case "PROTOCOLO":
               //    Toast.makeText(this,"Selecciona Protocolo",Toast.LENGTH_LONG);
              //  break;

        }
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




    //metodo para regreso al menu

    public void Menu(View view){
        Intent menu= new Intent(this, MainActivity.class);
        startActivity(menu);
    }

}
