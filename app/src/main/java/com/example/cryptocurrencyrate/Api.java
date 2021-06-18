package com.example.cryptocurrencyrate;
import com.example.cryptocurrencyrate.model.Crupt;
import com.example.cryptocurrencyrate.model.CruptRateList;
import com.example.cryptocurrencyrate.model.CruptsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    final String BASE_URL = "https://api.coincap.io/v2/";

    @GET("assets")
    Call<CruptsList> getCrupt();



    final String RATE_URL = "https://api.coincap.io/v2/assets/";

    @GET("history?interval=d1")
    Call<CruptRateList> getCruptRate ();
}
