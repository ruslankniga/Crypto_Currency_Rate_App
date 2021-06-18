package com.example.cryptocurrencyrate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CruptsList {

    @SerializedName("data")
    @Expose
    public List<Crupt> crupts = null;


    public List<Crupt> getCrupts()
    {
        return crupts;
    }

    public void setCrupts(List<Crupt> cruptsList)
    {
        crupts = cruptsList;
    }

    public Crupt getByIndex(int index){
        return crupts.get(index);
    }

    public int getSize(){
        return crupts.size();
    }
}
