package com.example.recyclerviewimgenes;

public class datosLista {

    private String url;
    private String dato;

    public datosLista(String url,String dato){

        this.url = url;
        this.dato= dato;
    }

    public String getUrl(){return  url;}
    public String getDato(){return  dato;}

}
