package com.aplimelta.belajarjava.oop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);
    ArrayList<Perpustakaan> perpus = new ArrayList<>();
    Perpustakaan p;
    int choice, id;
    boolean isNext = true;
    String name, type;

    Main(){
        try {
            while(isNext){
                System.out.println("=====DATABASE PERPUSTAKAAN=====");
                System.out.println("|\t1. Create");
                System.out.println("|\t2. Read");
                System.out.println("|\t3. Update");
                System.out.println("|\t4. Delete");
                System.out.println("|\t5. Exit");
                System.out.println("===============================");
                System.out.print("Enter your Choice [1-5] >> ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        insertData();
                        break;
                    case 2:
                        readData();
                        break;
                    case 3:
                        updateData();
                        break;
                    case 4:
                        deleteData();
                        break;
                }
            }
        } catch (InputMismatchException e) {
            e.getMessage();
        }
    }

    private void deleteData(){
        readData();
        System.out.print("Insert ID Buku >> ");
        id = input.nextInt();
        int index = 0, flag = 0;
        for ( Perpustakaan p : perpus ) {
            if (id == p.getId()){
                flag = 1;
                perpus.remove(index);
                System.out.println("Delete Succes!");
                break;
            }
            index++;
        }
        if (flag == 0){
            System.out.println("Buku Kosong!");
            input.nextLine();
        }
    }

    private void updateData(){
        readData();
        System.out.print("Insert ID Buku >> ");
        id = input.nextInt();
        int flag = 0;
        for ( Perpustakaan p : perpus ) {
            if (id == p.getId()) {
                flag = 1;
                do {
                    System.out.print("\t->[Pelajaran]\n\t->[Novel]\n\t->[Komik]\n\t->[Majalah]\nUpdate Jenis Buku\t>> ");
                    type = input.next();
                    p.setType(type);
                }while(!type.equals("Pelajaran") && !type.equals("Novel") &&
                        !type.equals("Komik") && !type.equals("Majalah"));

                do {
                    System.out.print("Update Nama Buku >> ");
                    name = input.next();
                    p.setName(name);
                } while (name.length() < 3 || name.length() > 20);

                System.out.println("Update Succes!");
                break;
            }
        }
        if (flag == 0){
            System.out.println("Buku Kosong!");
            input.nextLine();
        }

    }

    private void readData() {
        System.out.println("\n===== Book Data Show =====");
        for (Perpustakaan p : perpus) {
            System.out.println("ID : " + p.getId() + ", Buku : " + p.getName() + ", Jenis : " + p.getType());
        }
        System.out.println("============================");
    }

    private void insertData() throws InputMismatchException {
        do {
            System.out.print("Insert ID Buku\t\t>> ");
            id = input.nextInt();
        }while(id == 0);

        do {
            System.out.print("\t->[Pelajaran]\n\t->[Novel]\n\t->[Komik]\n\t->[Majalah]\nPilih Jenis Buku\t>> ");
            type = input.next();
        }while(!type.equals("Pelajaran") && !type.equals("Novel") &&
                !type.equals("Komik") && !type.equals("Majalah"));

        do {
            System.out.print("Insert Nama Buku\t>> ");
            name = input.next();
        }while(name.length() < 3 || name.length() > 20);

        p = new Perpustakaan(id, name, type);
        perpus.add(p);

        System.out.println("Insert Sukses!");
        input.nextLine();
    }

    public static void main(String[] args){
        new Main();
    }
}
