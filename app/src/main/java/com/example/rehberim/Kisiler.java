package com.example.rehberim;

import android.graphics.Bitmap;

public class Kisiler {
    private String telAd;
    private String telNumara;
    private Bitmap telFoto;
    private String telId;


    Kisiler(String kisiAdi, String numara, Bitmap foto, String telId) {
        this.telAd = kisiAdi;
        this.telNumara = numara;
        this.telFoto = foto;
        this.telId = telId;
    }

    public String getTelAd() {
        return telAd;
    }

    public void setTelAd(String telAd) {
        this.telAd = telAd;
    }

    public String getTelNumara() {
        return telNumara;
    }

    public void setTelNumara(String telNumara) {
        this.telNumara=telNumara;
    }

    public void setTelFoto(Bitmap telFoto) { this.telFoto=telFoto; }

    public Bitmap getTelFoto() {
        return telFoto;
    }

    public String getTelId() { return telId; }

    public void setTelId(String telId) { this.telId = telId; }
}