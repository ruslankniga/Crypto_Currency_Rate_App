package com.example.cryptocurrencyrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cryptocurrencyrate.model.Crupt;
import com.example.cryptocurrencyrate.model.CruptAdapter;
import com.example.cryptocurrencyrate.model.CruptsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<CruptsList> call = api.getCrupt();

        call.enqueue(new Callback<CruptsList>() {
            @Override
            public void onResponse(Call<CruptsList> call, Response<CruptsList> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                CruptsList cruptsList = response.body();
                CruptAdapter cruptAdapter = new CruptAdapter(MainActivity.this, cruptsList);
                recyclerView.setAdapter(cruptAdapter);
            }

            @Override
            public void onFailure(Call<CruptsList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}