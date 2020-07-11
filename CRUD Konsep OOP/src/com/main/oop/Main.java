package com.main.oop;

// java library
import java.util.Scanner;
// activity library
import com.crud.oop.Activity;

public class Main {

    Scanner input = new Scanner(System.in);
    String choice;

    Main(){
        while (true) {
            System.out.println("=====DATABASE PERPUSTAKAAN=====");
            System.out.println("|\t1. Create");
            System.out.println("|\t2. Read");
            System.out.println("|\t3. Update");
            System.out.println("|\t4. Delete");
            System.out.println("|\t5. Exit");
            System.out.println("===============================");
            System.out.print("Enter your Choice [1-5] >> ");
            choice = input.next();
            switch (choice) {
                case "1":
                    Activity.insertData();
                    break;
                case "2":
                    Activity.readData();
                    break;
                case "3":
                    Activity.readData();
                    Activity.updateData();
                    break;
                case "4":
                    Activity.readData();
                    Activity.deleteData();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan Salah Bro!");
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
