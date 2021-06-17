package com.example.cryptocurrencyrate.model;

import java.util.List;

public class CruptsList {

    private List<Crupt> crupts;

    public CruptsList(List<Crupt> crupts) {
        this.crupts = crupts;
    }

    public List<Crupt> getCrupts() {
        return crupts;
    }

    public void setCrupts(List<Crupt> crupts) {
        this.crupts = crupts;
    }

    public void addCrupts(Crupt crupt){ crupts.add(crupt); }

    public int getSize(){
        return crupts.size();
    }

    public Crupt getByIndex(int i){
        return crupts.get(i);
    }
}
