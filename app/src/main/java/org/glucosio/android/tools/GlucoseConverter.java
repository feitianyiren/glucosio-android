package org.glucosio.android.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GlucoseConverter {
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public int glucoseToMgDl(double mmolL) {
        double converted = mmolL * 18;
        return (int) converted;
    }

    public double glucoseToMmolL(double mgDl) {
        return round(mgDl / 18.0, 1);
    }

    public double glucoseToA1C(double mgDl) {
        // A1C = (Average glucose + 46.7) / 28.7
        return round((mgDl + 46.7) / 28.7, 2);
    }
}
