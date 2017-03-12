package com.noworries.scibots.noworries;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by aniket sharma on 11-03-2017.
 */

public class MylocationListner implements LocationListener {
    @Override
    public void onLocationChanged(Location location) {

        String longitude = "Longitude: " + location.getLongitude();
        Log.d("lng ", longitude);
        String latitude = "Latitude: " + location.getLatitude();
        Log.d("lat", latitude);
    }
    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
