package com.example.uas_yuliaayurinjani;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import com.example.uas_yuliaayurinjani.model.Mobil;
import com.example.uas_yuliaayurinjani.model.Honda;
import com.example.uas_yuliaayurinjani.model.Toyota;
import com.example.uas_yuliaayurinjani.model.Bmw;
public class DataProvider {
    private static List<Mobil> mobils = new ArrayList<>();

    private static List<Honda> initHonda(Context ctx) {
        List<Honda> hondas = new ArrayList<>();
        hondas.add(new Honda(ctx.getString(R.string.avanza), ctx.getString(R.string.avanza_jenis),
                ctx.getString(R.string.avanza_deskripsi), R.drawable.avanza));
        hondas.add(new Honda(ctx.getString(R.string.xenia), ctx.getString(R.string.xenia_jenis),
                ctx.getString(R.string.xenia_deskripsi), R.drawable.xenia));
        hondas.add(new Honda(ctx.getString(R.string.honda_hrv), ctx.getString(R.string.honda_hrv_jenis),
                ctx.getString(R.string.honda_hrv_deskripsi), R.drawable.hrv));
        return hondas;
    }

    private static List<Toyota> initToyota(Context ctx) {
        List<Toyota> toyotas = new ArrayList<>();
        toyotas.add(new Toyota(ctx.getString(R.string.inova), ctx.getString(R.string.inova_jenis),
                ctx.getString(R.string.inova_deskripsi), R.drawable.inova));
        toyotas.add(new Toyota(ctx.getString(R.string.civic), ctx.getString(R.string.civic_jenis),
                ctx.getString(R.string.civic_deskripsi), R.drawable.civic));
        toyotas.add(new Toyota(ctx.getString(R.string.brio), ctx.getString(R.string.brio_jenis),
                ctx.getString(R.string.brio_deskripsi), R.drawable.inova));
        return toyotas;
    }

    private static List<Bmw> initBMW(Context ctx) {
        List<Bmw> bmws = new ArrayList<>();
        bmws.add(new Bmw(ctx.getString(R.string.bmw1), ctx.getString(R.string.bmw1_jenis),
                ctx.getString(R.string.bmw_deskripsi), R.drawable.bmwx1));
        bmws.add(new Bmw(ctx.getString(R.string.bmw2), ctx.getString(R.string.bmw_jenis),
                ctx.getString(R.string.bmw2_deskripsi), R.drawable.bmwx2));
        bmws.add(new Bmw(ctx.getString(R.string.bmw3), ctx.getString(R.string.bmw3_jenis),
                ctx.getString(R.string.bmw3_deskripsi), R.drawable.bmwx3));
        return bmws;
    }


    private static void initAllMobil(Context ctx) {
        mobils.addAll(initHonda(ctx));
        mobils.addAll(initToyota(ctx));
        mobils.addAll(initBMW(ctx));
    }

    public static List<Mobil> getAllMobil(Context ctx) {
        if (mobils.size() == 0) {
            initAllMobil(ctx);
        }
        return  mobils;
    }

    public static List<Mobil> getMobilsByTipe(Context ctx, String jenis) {
        List<Mobil> mobilByType = new ArrayList<>();
        if (mobils.size() == 0) {
            initAllMobil(ctx);
        }
        for (Mobil m : mobils) {
            if (m.getJeniMobil().equals(jenis)) {
                mobilByType.add(m);
            }
        }
        return mobilByType;
    }
}
