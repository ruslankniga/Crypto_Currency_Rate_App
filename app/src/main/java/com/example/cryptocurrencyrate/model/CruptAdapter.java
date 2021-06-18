package com.example.cryptocurrencyrate.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrencyrate.Cryptocurrency_Data;
import com.example.cryptocurrencyrate.MainActivity;
import com.example.cryptocurrencyrate.R;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CruptAdapter extends RecyclerView.Adapter<CruptAdapter.CruptViewHolder> {

    CruptsList cruptList;
    Context context;
    RecyclerView recyclerView;

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int index = recyclerView.getChildLayoutPosition(v);

            Intent intent = new Intent(context, Cryptocurrency_Data.class);

            intent.putExtra("name", cruptList.getByIndex(index).getName());
            intent.putExtra("id", cruptList.getByIndex(index).getId());
            intent.putExtra("symbol", cruptList.getByIndex(index).getSymbol());

            context.startActivity(intent);
        }
    };

    public CruptAdapter(Context context, CruptsList crupts, RecyclerView recyclerView){
        this.context = context;
        cruptList = crupts;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public CruptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.crupt_item, parent, false);
        view.setOnClickListener(mOnClickListener);
        return new CruptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CruptViewHolder holder, int position) {

        Crupt crupt = cruptList.getByIndex(position);

        holder.rank.setText(crupt.getRank());
        holder.symbol.setText(crupt.getSymbol());
        holder.name.setText(crupt.getName());
        holder.priceUSD.setText(crupt.getPriceUsd());
        holder.changePrice24H.setText(crupt.getChangePercent24Hr());
    }

    @Override
    public int getItemCount() {
        return cruptList.getSize();
    }

    public static class CruptViewHolder extends RecyclerView.ViewHolder{
        TextView rank, symbol, name, priceUSD, changePrice24H;
        public CruptViewHolder(@NonNull View itemView) {
            super(itemView);

            rank = itemView.findViewById(R.id.rank);
            symbol = itemView.findViewById(R.id.symbol);
            name = itemView.findViewById(R.id.name);
            priceUSD = itemView.findViewById(R.id.priceUSD);
            changePrice24H = itemView.findViewById(R.id.changePrice24H);
        }
    }
}
