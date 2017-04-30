package com.bidjidevelops.justjava;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TanpaXml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tanpa_xml);
        TextView halo = new TextView(TanpaXml.this);
        halo.setText("Selamat datang");
        halo.setTextColor(Color.RED);
        halo.setTextSize(100);
        setContentView(halo);
    }
}
