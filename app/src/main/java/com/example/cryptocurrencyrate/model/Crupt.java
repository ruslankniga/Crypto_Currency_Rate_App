package com.example.cryptocurrencyrate.model;

import com.example.cryptocurrencyrate.СhangeFormat;

public class Crupt {

    private String id, rank, symbol, name, supply, maxSupply, marketCapUsd, volumeUsd24Hr, priceUsd, changePercent24Hr, vwap24Hr, explorer;

    public String getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getSupply() {

        return Double.toString(СhangeFormat.bdFormat(supply));
    }

    public String getMaxSupply() {
        return Double.toString(СhangeFormat.bdFormat(maxSupply));
    }

    public String getMarketCapUsd() {
        return Double.toString(СhangeFormat.bdFormat(marketCapUsd));
    }

    public String getVolumeUsd24Hr() {
        return Double.toString(СhangeFormat.bdFormat(volumeUsd24Hr));
    }

    public String getPriceUsd() {
        return Double.toString(СhangeFormat.bdFormat(priceUsd));
    }

    public String getChangePercent24Hr() {
        return Double.toString(СhangeFormat.bdFormat(changePercent24Hr));
    }

    public String getVwap24Hr() {
        return Double.toString(СhangeFormat.bdFormat(vwap24Hr));
    }

    public String getExplorer() {
        return explorer;
    }
}
