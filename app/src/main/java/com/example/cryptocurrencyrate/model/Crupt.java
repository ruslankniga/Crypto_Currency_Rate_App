package com.example.cryptocurrencyrate.model;

public class Crupt {
    private String id;
    private String rank;
    private String symbol;
    private String name;
    private String supply;
    private String maxSupply;
    private String marketCapUsd;
    private String volumeUsd24Hr;
    private String priceUSD;
    private String changePercent24Hr;
    private String vwap24Hr;
    private String explorer;

    public Crupt(String id, String rank, String symbol, String name, String supply,
                 String maxSupply, String marketCapUsd, String volumeUsd24Hr,
                 String priceUSD, String changePercent24Hr, String vwap24Hr, String explorer) {
        this.id = id;
        this.rank = rank;
        this.symbol = symbol;
        this.name = name;
        this.supply = supply;
        this.maxSupply = maxSupply;
        this.marketCapUsd = marketCapUsd;
        this.volumeUsd24Hr = volumeUsd24Hr;
        this.priceUSD = priceUSD;
        this.changePercent24Hr = changePercent24Hr;
        this.vwap24Hr = vwap24Hr;
        this.explorer = explorer;
    }

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
        return supply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public String getVolumeUsd24Hr() {
        return volumeUsd24Hr;
    }

    public String getPriceUSD() {
        return priceUSD;
    }

    public String getChangePercent24Hr() {
        return changePercent24Hr;
    }

    public String getVwap24Hr() {
        return vwap24Hr;
    }

    public String getExplorer() {
        return explorer;
    }
}
