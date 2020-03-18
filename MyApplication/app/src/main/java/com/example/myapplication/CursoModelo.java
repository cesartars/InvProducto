package com.example.myapplication;

public class CursoModelo {



    private String codigo,producto,dueño;

    public CursoModelo(){
    }

    public CursoModelo(String codigo, String producto, String dueño) {

        this.codigo = codigo;
        this.producto= producto;
        this.dueño=dueño;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }
}
