package com.clevertec.hometask4;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.clevertec.hometask4.databinding.ActivityMapsBinding;
import com.clevertec.hometask4.dto.AtmDto;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import static com.clevertec.hometask4.constants.Constants.LATITUDE_GOMEL;
import static com.clevertec.hometask4.constants.Constants.LONGITUDE_GOMEL;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng gomel = new LatLng(LATITUDE_GOMEL, LONGITUDE_GOMEL);
        //mMap.addMarker(new MarkerOptions().position(gomel).title("Marker in Gomel"));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(gomel)
                .zoom(8f)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), null);
        mMap.setTrafficEnabled(true);

        List<AtmDto> atmDto = new ArrayList<>();

        //double x = Double.parseDouble(atmDto.get(1).getGps_x());
        //double y = Double.parseDouble(atmDto.get(1).getGps_y());
        //mMap.addMarker(new MarkerOptions().position(new LatLng(x, y)).title("Marker in Gomel"));
        //mMap.setMapType(MAP_TYPE_NORMAL);
        System.out.println("F");
    }
}