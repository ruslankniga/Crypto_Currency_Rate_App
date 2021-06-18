package com.example.cryptocurrencyrate.model;

import com.example.cryptocurrencyrate.СhangeFormat;

public class CruptRate {

    String priceUsd, time, date;

    public Double getPriceUsd() {
        return СhangeFormat.bdFormat(priceUsd);
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
