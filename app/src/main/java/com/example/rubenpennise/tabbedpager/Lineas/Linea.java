package com.example.rubenpennise.tabbedpager.Lineas;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Ruben Pennise on 05/01/2015.
 */
public class Linea {

    private Long id;
    private String nombre;
    private ArrayList<LatLng> listaPuntos;
    public Linea(){

    }
    public Linea(Long id, String nombre, ArrayList<LatLng> listaPuntos) {
        this.id = id;
        this.nombre = nombre;
        this.listaPuntos = listaPuntos;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<LatLng> getListaPuntos() {
        return listaPuntos;
    }

    public void setListaPuntos(ArrayList<LatLng> listaPuntos) {
        this.listaPuntos = listaPuntos;
    }
}
