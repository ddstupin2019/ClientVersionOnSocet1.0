package com.example.myapplication.HelperClass;

public class InfoRozSt1 {
    private String name;
    private Integer stavka;
    private Boolean shod;

    public InfoRozSt1(String name, Integer stavka, Boolean shod) {
        this.name = name;
        this.stavka = stavka;
        this.shod = shod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStavka() {
        return stavka;
    }

    public void setStavka(Integer stavka) {
        this.stavka = stavka;
    }

    public Boolean getShod() {
        return shod;
    }

    public void setShod(Boolean shod) {
        this.shod = shod;
    }
}
