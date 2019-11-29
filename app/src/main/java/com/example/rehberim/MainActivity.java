package com.example.rehberim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    ArrayList<Kisiler> kisi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.beef);
        ListView listView = findViewById(R.id.listView);
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null, null);


        if ((cursor != null ? cursor.getCount() : 0) > 0) {
            while (cursor.moveToNext()) {
                String telId = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                String isim = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String numara = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                String fotoUri = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));

                if (fotoUri != null) {
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(contentResolver, Uri.parse(fotoUri));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    bitmap = null;
                }
                // Set<Kisiler> set = new LinkedHashSet<>();
                // set.addAll(kisi);
                // kisi.clear();
                //   kisi.addAll(set);
               // kisi.stream().distinct().collect(Collectors.toList());
                kisi.add(new Kisiler(isim, numara, bitmap, telId));

            }
        }
        cursor.close();
        Adaptor adaptor = new Adaptor(this, kisi);
        listView.setAdapter(adaptor);
    }


}

