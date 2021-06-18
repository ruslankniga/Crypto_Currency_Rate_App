package com.example.cryptocurrencyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cryptocurrencyrate.model.CruptRateList;
import com.example.cryptocurrencyrate.model.CruptsList;
import com.jjoe64.graphview.GraphView;


import com.example.cryptocurrencyrate.model.Crupt;
import com.example.cryptocurrencyrate.model.CruptAdapter;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cryptocurrency_Data extends AppCompatActivity {

    private TextView rank;
    private TextView name;
    private TextView priceUsd;
    private TextView supply;
    private TextView maxSupply;
    private TextView volumeUsd24Hr;
    private TextView changePercent24Hr;
    private TextView vwap24Hr;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptocurrency__data);

        intent = getIntent();
        rank = findViewById(R.id.rank_data);
        name  = findViewById(R.id.name_data);
        priceUsd  = findViewById(R.id.priceUsd_data);
        supply  = findViewById(R.id.suply_data);
        maxSupply  = findViewById(R.id.maxSuply_data);
        volumeUsd24Hr  = findViewById(R.id.volumeUsd24Hr_data);
        changePercent24Hr  = findViewById(R.id.changePercent24Hr_data);
        vwap24Hr  = findViewById(R.id.vwap24Hr_data);

        rank.setText(intent.getStringExtra("rank") + "|");
        name.setText(intent.getStringExtra("name"));
        priceUsd.setText("USD " + intent.getStringExtra("priceUsd"));
        supply.setText("Доступный запас " + intent.getStringExtra("supply"));
        maxSupply.setText("Общее кол-во активов " + intent.getStringExtra("maxSupply"));
        volumeUsd24Hr.setText("Кол-во торгового объема в USD за 24H " + intent.getStringExtra("volumeUsd24Hr"));
        changePercent24Hr.setText("24H   " + intent.getStringExtra("changePercent24Hr"));
        if(Double.parseDouble(intent.getStringExtra("changePercent24Hr")) > 0){
            changePercent24Hr.setTextColor(Color.GREEN);
        }
        else{
            changePercent24Hr.setTextColor(Color.RED);
        }
        vwap24Hr.setText("Средняя цена за последние 24H "+ intent.getStringExtra("vwap24Hr"));

        Request();

    }

    public void Request()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.RATE_URL +intent.getStringExtra("id")+ "/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<CruptRateList> call = api.getCruptRate();

        call.enqueue(new Callback<CruptRateList>() {
            @Override
            public void onResponse(Call<CruptRateList> call, Response<CruptRateList> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(Cryptocurrency_Data.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                buildGraph(response.body());
            }

            @Override
            public void onFailure(Call<CruptRateList> call, Throwable t) {
                Toast.makeText(Cryptocurrency_Data.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void buildGraph(CruptRateList cruptRateList)
    {
        GraphView graphView = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series =
                new LineGraphSeries<>();

        for (int i = 0; i < cruptRateList.getSize(); i++)
        {
            series.appendData( new DataPoint(i,cruptRateList.getByIndex(i).getPriceUsd()), true, cruptRateList.getSize());
        }

        graphView.addSeries(series);
        series.setColor(Color.BLUE);
        series.setTitle(intent.getStringExtra("symbol"));

        graphView.setTitleColor(Color.BLUE);
        graphView.setTitleTextSize(46);
        graphView.getLegendRenderer().setVisible(true);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

}