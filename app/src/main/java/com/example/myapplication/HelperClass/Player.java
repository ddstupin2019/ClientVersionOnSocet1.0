package com.example.myapplication.HelperClass;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Integer backStavka=0;
    private Integer balance;
    private Integer num;
    private String name;
    private Socket socket;
    private Integer maxPlayer;
    private Scanner scanner;
    private PrintWriter input;
    private final String adres="localhost";
    private final Integer port=8080;
    private final Integer codGame=-1111;
    private ArrayList<Integer> monCol, nedCol;

    public Integer getBackStavka() {
        return backStavka;
    }

    public void setBackStavka(Integer backStavka) {
        this.backStavka = backStavka;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Integer getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(Integer maxPlayer) {
        this.maxPlayer = maxPlayer;
        if (maxPlayer==3 || maxPlayer==4){
            balance=18;
        }else {
            balance=16;
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public PrintWriter getInput() {
        return input;
    }

    public void setInput(PrintWriter input) {
        this.input = input;
    }

    public String getAdres() {
        return adres;
    }

    public Integer getPort() {
        return port;
    }

    public Integer getCodGame() {
        return codGame;
    }

    public ArrayList<Integer> getMonCol() {
        return monCol;
    }

    public void setMonCol(ArrayList<Integer> monCol) {
        this.monCol = monCol;
    }

    public ArrayList<Integer> getNedCol() {
        return nedCol;
    }

    public void setNedCol(ArrayList<Integer> nedCol) {
        this.nedCol = nedCol;
    }
}
