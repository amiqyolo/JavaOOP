package com.crud.oop;

import java.util.Random;
import java.util.Scanner;

public class Utility {

    static Scanner input = new Scanner(System.in);
    private static String output;

    public static String primaryKey(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        char[] idRand = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        for (int i = 0; i < 6; i++){
            Character character = idRand[random.nextInt(idRand.length)];
            sb.append(character);
        }
        output = sb.toString();
        sb.delete(0, 10);
        return output;
    }

    public static boolean getYesNo(String message){
        System.out.print("\n"+message+" [y/n] >> ");
        String userOptions = input.next();

        while(!userOptions.equalsIgnoreCase("y") && !userOptions.equalsIgnoreCase("n")) {
            System.err.println("Oops! Pilihan bukan Y or N Bro");
            System.out.print("\n"+message+" [y/n] >> ");
            userOptions = input.next();
        }

        return userOptions.equalsIgnoreCase("y");
    }

}
