package com.clevertec.hometask4.api;

import com.clevertec.hometask4.dto.AtmDto;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AtmApi {

    @GET("atms")
    Call<List<AtmDto>> getAtm();
}
