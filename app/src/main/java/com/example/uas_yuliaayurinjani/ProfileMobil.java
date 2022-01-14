package com.example.uas_yuliaayurinjani;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.uas_yuliaayurinjani.model.Mobil;
import com.example.uas_yuliaayurinjani.model.Honda;
import com.example.uas_yuliaayurinjani.model.Toyota;
import com.example.uas_yuliaayurinjani.model.Bmw;

public class ProfileMobil extends AppCompatActivity {

    Mobil mobil;
    TextView txJudul, txJenis, txAsal, txDeskripsi;
    ImageView ivPosterFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        Intent intent = getIntent();
        mobil = (Mobil) intent.getSerializableExtra(DaftarMobilActivity.MOBIL_TERPILIH);
        inisialisasiView();
        tampilkanProfil(mobil);
    }

    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txGenre);
        txAsal = findViewById(R.id.txNama);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivPosterFilm = findViewById(R.id.gambarMobil);
    }


    private void tampilkanProfil(Mobil mobil) {
        Log.d("Profil", "Menampilkan " + mobil.getJeniMobil());

        if (mobil instanceof Honda) {
            txJudul.setText(R.string.honda);
        } else if (mobil instanceof Toyota) {
            txJudul.setText(R.string.toyota);
        } else if (mobil instanceof Bmw) {
            txJudul.setText(R.string.bmw);
        }
        txJudul.setText(mobil.getNamaMobil());
        txJenis.setText(mobil.getJeniMobil());
        txAsal.setText(mobil.getAsalMobil());
        txDeskripsi.setText(mobil.getDescMobil());
        ivPosterFilm.setImageDrawable(this.getDrawable(mobil.getGambarMobil()));
    }
}

