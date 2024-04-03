package com.emergentes.modelo;

public class Estudiante {
        private int Id;
        private String Nombre;
        private int P1;
        private int P2;
        private int EF;
        private int Nota;

    public Estudiante() {
        this.Id = 0;
        this.Nombre=" ";
        this.P1 = 0;
        this.P2 = 0;
        this.EF = 0;
        this.Nota = 0;
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getP1() {
        return P1;
    }

    public void setP1(int P1) {
        this.P1 = P1;
    }

    public int getP2() {
        return P2;
    }

    public void setP2(int P2) {
        this.P2 = P2;
    }

    public int getEF() {
        return EF;
    }

    public void setEF(int EF) {
        this.EF = EF;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int Nota) {
        this.Nota = Nota;
    }
        
    
        
}
