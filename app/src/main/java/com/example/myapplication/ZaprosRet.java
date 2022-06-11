package com.example.myapplication;

import com.example.myapplication.HelperClass.InfoRozSt1;
import com.example.myapplication.HelperClass.ParseString;
import com.example.myapplication.HelperClass.Player;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ZaprosRet{
    Player player;
    Integer i;
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setDan(){

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    player.setSocket(new Socket(player.getAdres(),player.getPort()));
                    player.setInput(new PrintWriter(player.getSocket().getOutputStream()));
                    player.setScanner(new Scanner(player.getSocket().getInputStream()));
                    otprMes(String.valueOf(player.getCodGame()));
                    otprMes(String.valueOf(player.getMaxPlayer()));
                    otprMes(player.getName());
                    setCol();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();



    }
   public void otprMes(String message){
        new Thread(){
            @Override
            public void run() {
                super.run();
                player.getInput().print(message);
                player.getInput().flush();
            }
        }.start();

    }
    private void setCol(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                switch (player.getScanner().nextInt()){
                    case -1:
                        player.setNedCol(ParseString.parserString(player.getScanner().nextLine()));
                        setCol();
                        break;
                    case -2:
                        player.setMonCol(ParseString.parserString(player.getScanner().nextLine()));
                        setCol();
                        break;
                    case -6:
                        player.setNum(player.getScanner().nextInt());
            }
        }
        }.start();
    }

    public Integer getBadSt(){
        final Scanner[] scanner = new Scanner[1];
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    scanner[0] =new Scanner(player.getSocket().getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return scanner[0].nextInt();
    }


    public ArrayList<InfoRozSt1> shitStadia1(){
        ArrayList<InfoRozSt1> rez=new ArrayList<>();
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    String[] s=null;
                    Integer[] x=null;
                    Boolean[] w=null;
                    String a;

                    Scanner scanner=new Scanner(player.getSocket().getInputStream());
                    while (scanner.hasNext()){
                        switch (scanner.nextInt()) {
                            case -15:
                                a=scanner.nextLine();
                                s=a.split(" ");
                                break;
                            case 30:
                                a=scanner.nextLine();
                                x=ParseString.parserInteger(a.split(" "));
                                break;
                            case 45:
                                a=scanner.nextLine();
                                w=ParseString.parserBollean(a.split(" "));
                                break;
                        }
                    }
                    for (int j = 0; j < rez.size(); j++) {
                        rez.add(new InfoRozSt1(s[i],x[i],w[i]));
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return rez;

    }
}
