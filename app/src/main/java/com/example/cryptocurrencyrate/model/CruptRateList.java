package com.example.cryptocurrencyrate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CruptRateList {

    @SerializedName("data")
    @Expose
    public List<CruptRate> cruptRates = null;


    public List<CruptRate> getCrupts()
    {
        return cruptRates;
    }

    public void setCrupts(List<CruptRate> cruptRates)
    {
        this.cruptRates = cruptRates;
    }

    public CruptRate getByIndex(int index){
        return cruptRates.get(index);
    }

    public int getSize(){
        return cruptRates.size();
    }
}
