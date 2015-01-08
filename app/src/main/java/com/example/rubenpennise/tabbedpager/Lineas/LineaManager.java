package com.example.rubenpennise.tabbedpager.Lineas;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Ruben Pennise on 05/01/2015.
 */
public class LineaManager {

    private ArrayList<LatLng> listaPuntos101 = new ArrayList<LatLng>();
    private ArrayList<Linea> listaLineas = new ArrayList<Linea>();
    ArrayList<LatLng> listaPuntos503 = new ArrayList<LatLng>();

    public void crearLineas(){

        // LINEA 101
        Linea linea101 = new Linea();

        LatLng punto_1  = new LatLng(-28.46931871608501, -65.82469119780718);
        LatLng punto_2  = new LatLng(-28.4707828084775, -65.82046858187624);
        LatLng punto_3  = new LatLng(-28.47162087944096, -65.81768833861437);
        LatLng punto_4  = new LatLng(-28.47140879105224, -65.81311768005617);
        LatLng punto_5  = new LatLng(-28.47139167501839, -65.81312185687355);
        LatLng punto_6  = new LatLng(-28.47034013258248, -65.79765699856471);
        LatLng punto_7  = new LatLng(-28.47017448680375, -65.78687312679594);
        LatLng punto_8  = new LatLng(-28.46910015895962, -65.78652839183441);
        LatLng punto_9  = new LatLng(-28.46890765568541, -65.78687087149737);
        LatLng punto_10  = new LatLng(-28.46078764592279, -65.78724202223992);
        LatLng punto_11  = new LatLng(-28.46055959240657, -65.78164760735237);
        LatLng punto_12  = new LatLng(-28.47610104419576, -65.78090805158415);
        LatLng punto_13  = new LatLng(-28.47609222373413, -65.78094232126722);
        LatLng punto_14  = new LatLng(-28.47563633159643, -65.76949941774687);
        LatLng punto_15  = new LatLng(-28.46748091743491, -65.7698250316616);
        LatLng punto_16  = new LatLng(-28.46731015184562, -65.76792093532868);
        LatLng punto_17  = new LatLng(-28.46587558697451, -65.76776403432639);
        LatLng punto_18  = new LatLng(-28.46534152112409, -65.76756098768458);
        LatLng punto_19  = new LatLng(-28.4646472748861, -65.76687526784382);
        LatLng punto_20  = new LatLng(-28.46463181629138, -65.7661665602926);
        LatLng punto_21  = new LatLng(-28.46445113834244, -65.76601275944114);
        LatLng punto_22  = new LatLng(-28.46414258540274, -65.76617124609581);


        listaPuntos101.add(punto_1);
        listaPuntos101.add(punto_2);
        listaPuntos101.add(punto_3);
        listaPuntos101.add(punto_4);
        listaPuntos101.add(punto_5);
        listaPuntos101.add(punto_6);
        listaPuntos101.add(punto_7);
        listaPuntos101.add(punto_8);
        listaPuntos101.add(punto_9);
        listaPuntos101.add(punto_10);
        listaPuntos101.add(punto_11);
        listaPuntos101.add(punto_12);
        listaPuntos101.add(punto_13);
        listaPuntos101.add(punto_14);
        listaPuntos101.add(punto_15);
        listaPuntos101.add(punto_16);
        listaPuntos101.add(punto_17);
        listaPuntos101.add(punto_18);
        listaPuntos101.add(punto_19);
        listaPuntos101.add(punto_20);
        listaPuntos101.add(punto_21);
        listaPuntos101.add(punto_22);

        linea101.setListaPuntos(listaPuntos101);
        linea101.setNombre("101");
        linea101.setId(1L);


        listaLineas.add(linea101);

        Linea linea503 =new Linea();

        LatLng punto_23=new LatLng(-28.48211774040582,-65.79352458735365);
        LatLng punto_24=new LatLng(-28.48204197331593,-65.79232096589863);
        LatLng punto_25=new LatLng(-28.48199124221545,-65.7916462403378);
        LatLng punto_26=new LatLng(-28.48189663631807,-65.79071598804423);
        LatLng punto_27=new LatLng(-28.48190050646215,-65.78964135648468);
        LatLng punto_28= new LatLng(-28.48202067799064,-65.78769470121114);
        LatLng punto_29 =new LatLng(-28.48217106989901,-65.7858507787991);
        LatLng punto_30 =new LatLng(-28.48236256696674,-65.78418627551402);
        LatLng punto_31 =new LatLng(-28.48240250647536,-65.78243039010931);
        LatLng punto_32 =new LatLng(-28.48250005785362,-65.78075308744761);
        LatLng punto_33=new LatLng(-28.48444759458934,-65.78079478595809);
        listaPuntos503.add(punto_23);
        listaPuntos503.add(punto_24);
        listaPuntos503.add(punto_25);
        listaPuntos503.add(punto_26);
        listaPuntos503.add(punto_27);
        listaPuntos503.add(punto_28);
        listaPuntos503.add(punto_29);
        listaPuntos503.add(punto_30);
        listaPuntos503.add(punto_31);
        listaPuntos503.add(punto_32);
        listaPuntos503.add(punto_33);
        linea503.setId(2L);
        linea503.setNombre("503");
        linea503.setListaPuntos(listaPuntos503);

        listaLineas.add(linea503);


    }
    public ArrayList<Linea> getListaLineas(){
        this.crearLineas();
        if(listaLineas != null)
            return listaLineas;
        else
            return null;
    }
}
