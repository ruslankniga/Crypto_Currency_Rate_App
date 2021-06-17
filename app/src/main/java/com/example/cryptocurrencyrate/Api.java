package com.example.cryptocurrencyrate;
import com.example.cryptocurrencyrate.model.CruptsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    final String BASE_URL = "https://api.coincap.io/v2/";

    @GET("assets")
    Call<CruptsList> getCrupt();
}
