package com.clevertec.hometask4;

import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.clevertec.hometask4.api.AtmApiService;
import com.clevertec.hometask4.api.impl.AtmApiServiceImpl;
import com.clevertec.hometask4.databinding.ActivityMapsBinding;
import com.clevertec.hometask4.dto.AtmDto;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import static com.clevertec.hometask4.constants.Constants.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.clevertec.hometask4.databinding.ActivityMapsBinding binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        AtmApiService atmAnswer = new AtmApiServiceImpl(this);
        atmAnswer.getAtms(DEFAULT_CITY);
    }

    public void addMarkers(List<AtmDto> list) {

        LatLng gomel = new LatLng(DEFAULT_LATITUDE_COORD, DEFAULT_LONGITUDE_COORD);
        CameraPosition cameraPosition = CameraPosition.builder()
                .target(gomel)
                .zoom(8f)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), null);
        mMap.setTrafficEnabled(true);

        if (list != null && list.size() != 0) {
            for (AtmDto bank : list) {
                mMap.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(Double.parseDouble(bank.getGpsX()), Double.parseDouble(bank.getGpsY())))
                                .title(bank.getAddressType() + " " + bank.getAddress() + " " + bank.getHouse())
                                .snippet(bank.getInstallPlace())
                );
            }
        } else {
            Toast.makeText(this, NO_ATMS_IN_CITY_ERROR, Toast.LENGTH_SHORT).show();
        }
    }
}