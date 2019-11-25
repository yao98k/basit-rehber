package com.example.rehberim;

import android.graphics.Bitmap;

public class Kisiler {
    private String kisiAdi;
    private String numara;
   private Bitmap foto;


    Kisiler(String kisiAdi, String numara, Bitmap foto) {
        this.kisiAdi=kisiAdi;
        this.numara=numara;
       this.foto=foto;
    }

    public String getKisiAdi() {
        return kisiAdi;
    }

    public void setKisiAdi(String kisiAdi) {
        this.kisiAdi = kisiAdi;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

   public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public Bitmap getFoto() {
        return foto;
    }
}