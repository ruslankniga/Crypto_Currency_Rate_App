package com.example.cryptocurrencyrate.model;

import com.example.cryptocurrencyrate.–°hangeFormat;

public class CruptRate {

    String priceUsd, time, date;

    public Double getPriceUsd() {
        return –°hangeFormat.bdFormat(priceUsd);
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
