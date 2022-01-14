package com.example.uas_yuliaayurinjani;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uas_yuliaayurinjani.model.Mobil;
import com.example.uas_yuliaayurinjani.model.Honda;
import com.example.uas_yuliaayurinjani.model.Toyota;
import com.example.uas_yuliaayurinjani.model.Bmw;

import java.util.List;

public class DaftarMobilActivity extends AppCompatActivity {
    public final static String MOBIL_TERPILIH ="film_obj_key";
    List<Mobil> mobils;
    ListView listView;
    String jenisMobil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_mobil);
        Intent intent = getIntent();
        jenisMobil = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        TextView txJudul = findViewById(R.id.text_title_daftar_mobil);
        mobils = DataProvider.getMobilsByTipe(this,jenisMobil);

        String judul = "";
        if (mobils.get(0) instanceof Honda) {
            judul = getString(R.string.honda);
        } else if (mobils.get(0) instanceof Toyota) {
            judul = getString(R.string.toyota);
        } else if (mobils.get(0) instanceof Bmw) {
            judul = getString(R.string.bmw);
        }

        txJudul.setText(judul);

        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_mobil);
        DaftarMobilAdapter adapter = new DaftarMobilAdapter(this,mobils);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Mobil terpilih = mobils.get(position);
            bukaGaleriFilm(terpilih);
        }
    };

    private void bukaGaleriFilm(Mobil mobilT) {
        Log.d("MAIN","Buka activity galeri");
        Intent inten1 = new Intent(getApplicationContext(), ProfileMobil.class);
        inten1.putExtra(MOBIL_TERPILIH, mobilT);
        startActivity(inten1);
    }
}
