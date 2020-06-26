package com.aplimelta.belajarjava.oop;

public class Perpustakaan {
    // field
    private int id;
    private String name;
    private String type;

    // construktor
    public Perpustakaan(int id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    // getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

}

