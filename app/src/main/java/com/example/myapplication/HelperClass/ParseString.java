package com.example.myapplication.HelperClass;


import java.util.ArrayList;
import java.util.Scanner;

public class ParseString {

    public static ArrayList<Integer> parserString(String in){
        ArrayList<Integer> rez= new ArrayList<>();
        if(in!=null){
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextInt()) {
                rez.add(scanner.nextInt());
            }
        }
        return rez;
    }

    public static String parserArray(ArrayList<Integer> inp){
        String rez = "";
        for (int i = 0; i < inp.size(); i++) {
            rez+=String.valueOf(inp.get(i))+' ';
        }
        return rez;
    }

    public static Integer[] parserInteger(String[] inp){
        Integer[] rez=new Integer[inp.length];
        for (int i = 0; i < inp.length; i++) {
            rez[i]= Integer.valueOf(inp[i]);
        }
        return rez;
    }

    public static Boolean[] parserBollean(String[] inp){
        Boolean[] rez=new Boolean[inp.length];
        for (int i = 0; i < inp.length; i++) {
            if(inp[i].equals("true")){
                rez[i]=true;
            }else {
                rez[i]=false;
            }
        }
        return rez;
    }
}
