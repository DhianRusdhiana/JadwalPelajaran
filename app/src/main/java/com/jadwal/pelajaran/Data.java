package com.jadwal.pelajaran;

public class Data {
    public String title;
    public String description;
    public String nomor;
    public int warnaText;
    public int warna;


    Data(String nomor, String title, String description,int warna,int warnaText) {
        this.nomor = nomor;
        this.title = title;
        this.description = description;
        this.warna = warna;
        this.warnaText = warnaText;

    }

}

