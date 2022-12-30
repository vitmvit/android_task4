package com.clevertec.hometask4.api;

import java.util.Optional;

public interface AtmApiProvider {

    Optional<AtmApi> getRemoteApi();
}
