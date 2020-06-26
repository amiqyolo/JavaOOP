package com.aplimelta.belajarjava.oop;

import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

class DataRoom {
    // field
    private String name;
    private int stock;
    private long price;
    private long total;

    // construktor
    DataRoom(String name, int stock, long price){
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.total = stock * price;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public long getPrice() {
        return price;
    }

    public long getTotal(){
        return total;
    }

    public long getAllTotal(){
        return getTotal() + getTotal() + getTotal();
    }

}

class ShowData {
    // number instance
    public NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("in", "ID"));

    // instansiasi arrayList
    ArrayList<DataRoom> show;

    // construktor
    ShowData(){
        show = new ArrayList<>();
    }

    // setter
    public void setData(String name, int stock, long price){
        show.add(new DataRoom(name,stock,price));
    }

    // fungsi menapilkan data
    public void display(){
        int i = 0;
        for ( DataRoom dataRoom : show ) {
            i++;
            System.out.println("Car Name\t\t: " + dataRoom.getName());
            System.out.println("Car Stock\t\t: " + dataRoom.getStock());
            System.out.println("Car Price\t\t: " + numberFormat.format(dataRoom.getPrice()));
            System.out.println("--------------------------------");
            System.out.println("Total Price\t\t: " + numberFormat.format(dataRoom.getTotal()) + "\n");
            if(i % show.size() == 0){
                System.out.println("Total All Price : " + numberFormat.format(dataRoom.getAllTotal()));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // instance class / object
        ShowData object = new ShowData();

        // memasukkan value
        object.setData("Kijang inova",12,350000000);
        object.setData("Daihatsu Xenia",13,190000000);
        object.setData("Toyota Avanza",15,205000000);

        // menapilkan data
        object.display();
    }
}
