package com.example.rehberim;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/*
Adapter bir veri kaynağıyla, veriye ihtiyacı olan nesneyi birbirine bağlamaya yarayan yapılardır.
ListView gibi bir dizi veriyi içinde bulunduran yapılara, bu verileri adapter aracılığıyla veririz.
 */
public class Adaptor extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<Kisiler> kisilerList;

    Adaptor(Activity activity, List<Kisiler> kisilerList) {
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.kisilerList = kisilerList;
    }

    @Override
    public int getCount() {
        return kisilerList.size();
    }

    @Override
    public Object getItem(int i) {
        return kisilerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View lineView;
        lineView = userInflater.inflate(R.layout.list_items, null);
        TextView textIsim =  lineView.findViewById(R.id.text_isim);
        TextView textNumara =  lineView.findViewById(R.id.text_numara);
        ImageView fotograf =  lineView.findViewById(R.id.image_kisi);

        Kisiler kisi = kisilerList.get(i);
        textIsim.setText(kisi.getTelAd());
        textNumara.setText(kisi.getTelNumara());
        fotograf.setImageBitmap(kisi.getTelFoto());

        return lineView;
    }
}