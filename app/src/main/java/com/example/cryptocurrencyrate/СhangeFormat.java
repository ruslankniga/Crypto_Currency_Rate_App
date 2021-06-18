package com.example.cryptocurrencyrate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface СhangeFormat {

    static double bdFormat(String value) {
        if (2 < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
