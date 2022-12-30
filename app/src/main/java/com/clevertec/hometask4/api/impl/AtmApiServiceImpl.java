package com.clevertec.hometask4.api.impl;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.clevertec.hometask4.api.AtmApi;
import com.clevertec.hometask4.api.AtmApiProvider;
import com.clevertec.hometask4.api.AtmApiService;
import com.clevertec.hometask4.dto.AtmDto;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AtmApiServiceImpl implements AtmApiService {

    private Optional<AtmApi> atmApi;

    public AtmApiServiceImpl(AtmApiProvider atmApiProvider) {
        atmApi = atmApiProvider.getRemoteApi();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<AtmDto> getAtms() {
        if (atmApi.isPresent()) {
            Call<List<AtmDto>> call = atmApi.get().getAtm();
            try {
                return call.execute().body();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
