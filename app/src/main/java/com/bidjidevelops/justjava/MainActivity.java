package com.bidjidevelops.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //        memberi nama variabel widget yang mewakilkan widget widget yang ada di layout
    Button btnorder;
    CheckBox checkbox_sambel,checkbox_makaroni;
    TextView quantity_Text_View, price_Text_view;
    //        membuat variabel yang langsung di isi datanya
    int quantity = 0;
    EditText edNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//            memperkenalkan widget yang ada di layout
        btnorder = (Button) findViewById(R.id.btn_order);
        quantity_Text_View = (TextView) findViewById(R.id.quantity_text_view);
        price_Text_view = (TextView) findViewById(R.id.price_Text_View);
        checkbox_sambel = (CheckBox) findViewById(R.id.checkbox_sambel);
        checkbox_makaroni = (CheckBox) findViewById(R.id.checkbox_makaroni);
        edNama = (EditText)findViewById(R.id.edNama);
//            onclick cara pertama cara kedua ada di layout
//            btnorder.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                }
//            });
    }

    //        membuat method yang dengan parametr di dalamnya nah untuk kali ini saya membuat parameternya dengan type data int
    private void tampil(int number) {
        quantity_Text_View.setText("" + number);

    }

    private int tampilharga(boolean checksambel , boolean checkmakaroni) {
//        mengubah text price_Text_view menjadi "RP.'nomer yang di input'"
        int harga_awal = 0;
        if(checksambel){
            harga_awal = harga_awal + 100;
        }
        if (checkmakaroni){
            harga_awal = harga_awal + 500;
        }
        int tampil = quantity * 2000;
        return tampil + harga_awal;

    }

    //    cara memanggil onclick yang ada di layout
    public String tampilkanHasil(int hasil,boolean checksambel,boolean checkmakroni) {
        String nama = edNama.getText().toString();
        String tampiHasil = "Nama " + nama;
        tampiHasil += "\nbanyak Pesanan : " + quantity;
        tampiHasil +="\ndiberi sambel ? " +checksambel;
        tampiHasil +="\ndiberi makaroni ? " +checkmakroni;
        tampiHasil += "\nharga : " + hasil;
        tampiHasil += "\nterimakasih telah beli seblak";
        return tampiHasil;
    }

    public void order(View v) {
//memanggil method yang di buat di atas dan memasukan quantity * 2000 sebagai parameternya
        boolean checksambel = checkbox_sambel.isChecked();
        boolean checkmakaroni = checkbox_makaroni.isChecked();
        System.out.println("di cecklis?" + checksambel);

        int tampilharga = tampilharga(checksambel,checkmakaroni);
        String pesantampilharga = tampilkanHasil(tampilharga,checksambel,checkmakaroni);
        tampilkanpesanhasil(pesantampilharga);
    }

    public void tambah(View v) {
        quantity = quantity + 1;
        tampil(quantity);
    }

    public void kurang(View v) {
        quantity = quantity - 1;
        tampil(quantity);
    }

    public void tampilkanpesanhasil(String pesanhasil) {
        price_Text_view.setText(pesanhasil);
    }
}
