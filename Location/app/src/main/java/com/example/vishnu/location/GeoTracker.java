package com.example.vishnu.location;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by vishnu-c on 8/13/17.
 */

public class GeoTracker implements LocationListener {



    Context context;

    public GeoTracker(Context c){
       context = c;
    }

    public Location getLocation(){
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context,"permission not granted",Toast.LENGTH_SHORT).show();
        }
        LocationManager locationManager =(LocationManager)context.getSystemService(context.LOCATION_SERVICE);
        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(isGPSEnabled){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,6000,6,this);
            Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            return loc;
        }
        else{
            Toast.makeText(context,"Please Enable GPS",Toast.LENGTH_SHORT).show();


        }
        return  null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);

    }
}
