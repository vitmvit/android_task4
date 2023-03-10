package com.clevertec.hometask4.api.impl;

import com.clevertec.hometask4.api.AtmApi;
import com.clevertec.hometask4.api.AtmApiProvider;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AtmApiProviderImpl implements AtmApiProvider {

    private final AtmApi atmApi;

    public AtmApiProviderImpl() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://belarusbank.by/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        atmApi = retrofit.create(AtmApi.class);
    }

    @Override
    public AtmApi getAtmApi() {
        return atmApi;
    }
}
