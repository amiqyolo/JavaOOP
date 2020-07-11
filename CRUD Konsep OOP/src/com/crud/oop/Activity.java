package com.crud.oop;

// java library
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Activity {

    private static String id, type, title, author, publisher;
    private static ArrayList<Perpustakaan> perpus = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void deleteData() throws InputMismatchException {
        boolean isContinue = Utility.getYesNo("Beneran Nih Mau Hapus Data Buku?");
        if (isContinue) {
            System.out.print("Insert ID Primary Buku\t>> ");
            id = input.next();
            int index = 0, flag = 0;
            for (Perpustakaan p : perpus) {
                if (p.getPrimaryKey().equals(id)) {
                    flag = 1;
                    perpus.remove(index);
                    System.out.println("Delete telah Berhasil!");
                    System.out.print("\n");
                    break;
                } else {
                    System.out.print("Insert ID Primary Buku\t>> ");
                    id = input.next();
                }
                index++;
            }
            if (flag == 0) {
                System.out.println("ID Primary tidak ditemukan!");
                input.nextLine();
            }
        }
    }

    public static void updateData() throws InputMismatchException {
        boolean isContinue = Utility.getYesNo("Yakin ingin Update Data?");
        if (isContinue) {
            System.out.print("Insert ID Primary Buku >> ");
            id = input.next();
            int flag = 0;
            for (Perpustakaan p : perpus) {
                if (p.getPrimaryKey().equals(id)) {
                    isContinue = Utility.getYesNo("Mau Update Jenis Buku?");
                    if (isContinue) {
                        do {
                            System.out.print("\t->[Komik]\n\t->[Novel]\n\t->[Pelajaran]\nUpdate Jenis Buku\t\t>> ");
                            type = input.next();
                            p.setType(type);
                        } while (!type.equals("Pelajaran") && !type.equals("Novel") && !type.equals("Komik"));
                    }

                    input.nextLine();
                    isContinue = Utility.getYesNo("Mau Update Judul Buku Juga?");
                    if (isContinue) {
                        do {
                            System.out.print("Update Judul Buku\t\t>> ");
                            title = input.nextLine();
                            p.setTitle(title);
                        } while (title.length() < 3 || title.length() > 20);
                    }

                    isContinue = Utility.getYesNo("Mau Update Penulis Buku Juga?");
                    if (isContinue) {
                        do {
                            System.out.print("Update Penulis Buku\t\t>> ");
                            author = input.nextLine();
                            p.setAuthor(author);
                        } while (author.length() < 3 || author.length() > 18);
                    }

                    isContinue = Utility.getYesNo("Mau Update Penerbit Buku Juga?");
                    if (isContinue) {
                        do {
                            System.out.print("Update Penerbit Buku\t>> ");
                            publisher = input.nextLine();
                            p.setPublisher(publisher);
                        } while (publisher.length() < 3 || publisher.length() > 20);
                    }

                    flag = 1;
                    System.out.println("Update telah Berhasil!");
                    break;
                }
            }

            if (flag == 0) {
                System.out.println("ID Primary tidak ditemukan!");
            }
        }
    }

    public static void readData() throws InputMismatchException {
        if (perpus.isEmpty()) {
            boolean isContinue = Utility.getYesNo("Data Kosong Bro! Mau Tambah Data dulu?");
            if (isContinue) {
                insertData();
            } else {
                System.exit(0);
            }
        } else {
            System.out.println("\n| No |\tID      |\tJudul Buku            |\tJenis Buku |\tPenulis             |\tPenerbit              |");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            int i = 0;
            for (Perpustakaan p : perpus) {
                i++;
                System.out.printf("| %-2d ", i);
                System.out.printf("|\t%6s  ", p.getPrimaryKey());
                System.out.printf("|\t%-20s  ", p.getTitle());
                System.out.printf("|\t%-9s  ", p.getType());
                System.out.printf("|\t%-18s  ", p.getAuthor());
                System.out.printf("|\t%-20s  ", p.getPublisher());
                System.out.print("|");
                System.out.print("\n");
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------");
        }

    }

    public static void insertData() throws InputMismatchException {
        do {
            System.out.print("\t->[Komik]\n\t->[Novel]\n\t->[Pelajaran]\nPilih Jenis Buku\t\t>> ");
            type = input.next();
            input.nextLine();
        } while(!type.equals("Pelajaran") && !type.equals("Novel") && !type.equals("Komik"));

        do {
            System.out.print("Masukkan Judul Buku\t\t>> ");
            title = input.nextLine();
        } while (title.length() < 3 || title.length() > 20);

        do {
            System.out.print("Masukkan Penulis Buku\t>> ");
            author = input.nextLine();
        } while (author.length() < 3 || author.length() > 18);

        do {
            System.out.print("Masukkan Penerbit Buku\t>> ");
            publisher = input.nextLine();
        } while (publisher.length() < 3 || publisher.length() > 20);

        Perpustakaan p = new Perpustakaan(Utility.primaryKey(), type, title, author, publisher);
        perpus.add(p);

        System.out.println("Insert Sukses!");
        System.out.print("\n");
    }

}
