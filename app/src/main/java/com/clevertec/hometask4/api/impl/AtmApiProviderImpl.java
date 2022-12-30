package com.clevertec.hometask4.api.impl;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.clevertec.hometask4.api.AtmApi;
import com.clevertec.hometask4.api.AtmApiProvider;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Optional;

public class AtmApiProviderImpl implements AtmApiProvider {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<AtmApi> getRemoteApi() {
        return Optional.of(
                new Retrofit.Builder()
                        .baseUrl("https://belarusbank.by/api/atm")
                        .addConverterFactory(
                                GsonConverterFactory.create(
                                        new GsonBuilder().setLenient().create()
                                )
                        )
                        .build()
                        .create(AtmApi.class)
        );
    }
}
