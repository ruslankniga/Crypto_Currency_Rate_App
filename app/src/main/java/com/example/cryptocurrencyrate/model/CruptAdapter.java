package com.example.cryptocurrencyrate.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrencyrate.R;

import java.util.List;

public class CruptAdapter extends RecyclerView.Adapter<CruptAdapter.CruptViewHolder> {

    CruptsList cruptList;
    Context context;


    public CruptAdapter(Context context, CruptsList crupts){
        this.context = context;
        cruptList = crupts;
    }

    @NonNull
    @Override
    public CruptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new CruptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CruptViewHolder holder, int position) {
        Crupt crupt = cruptList.getByIndex(position);

        holder.id.setText(crupt.getId());
        holder.rank.setText(crupt.getRank());
        holder.symbol.setText(crupt.getSymbol());
        holder.name.setText(crupt.getName());
        holder.supply.setText(crupt.getSupply());
        holder.maxSupply.setText(crupt.getMaxSupply());
        holder.marketCapUsd.setText(crupt.getMarketCapUsd());
        holder.volumeUsd24Hr.setText(crupt.getVolumeUsd24Hr());
        holder.priceUSD.setText(crupt.getPriceUSD());
        holder.changePrice24H.setText(crupt.getChangePercent24Hr());
        holder.vwap24Hr.setText(crupt.getVwap24Hr());
        holder.explorer.setText(crupt.getExplorer());
    }

    @Override
    public int getItemCount() {
        return cruptList.getSize();
    }

    public static class CruptViewHolder extends RecyclerView.ViewHolder{
        TextView id, rank, symbol, name, supply, maxSupply, marketCapUsd, volumeUsd24Hr, priceUSD, changePrice24H, vwap24Hr, explorer;
        public CruptViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            rank = itemView.findViewById(R.id.rank);
            symbol = itemView.findViewById(R.id.symbol);
            name = itemView.findViewById(R.id.name);
            supply = itemView.findViewById(R.id.supply);
            maxSupply = itemView.findViewById(R.id.maxSupply);
            marketCapUsd = itemView.findViewById(R.id.marketCapUsd);
            volumeUsd24Hr = itemView.findViewById(R.id.volumeUsd24Hr);
            priceUSD = itemView.findViewById(R.id.priceUSD);
            changePrice24H = itemView.findViewById(R.id.changePercent24Hr);
            vwap24Hr = itemView.findViewById(R.id.vwap24Hr);
            explorer = itemView.findViewById(R.id.explorer);
        }
    }
}
