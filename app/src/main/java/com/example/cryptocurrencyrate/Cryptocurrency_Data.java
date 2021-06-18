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

    private static TextView name;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptocurrency__data);

        intent = getIntent();
        name  = findViewById(R.id.name_data);


        name.setText(intent.getStringExtra("name"));

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
        //series.setDrawDataPoints(true);
        //series.setDataPointsRadius(10);

        graphView.setTitle("График изменения курса с интервалом 1d");
        graphView.setTitleTextSize(46);
        graphView.setTitleColor(Color.BLUE);
        graphView.getLegendRenderer().setVisible(true);
        graphView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

}