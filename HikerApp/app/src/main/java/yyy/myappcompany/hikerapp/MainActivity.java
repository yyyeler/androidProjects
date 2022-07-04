package yyy.myappcompany.hikerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.app.LoaderManager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView latitude,longitude,accuracy,altitude,address;
    LocationManager locationManager;
    LocationListener locationListener;
    Geocoder geocoder;
    List <Address> addresses,LastKnownaddresses;

    @Override
    public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions,@NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geocoder = new Geocoder(this, Locale.getDefault());

        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        accuracy = findViewById(R.id.accuracy);
        altitude = findViewById(R.id.altitude);
        address = findViewById(R.id.address);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                double lng = location.getLongitude();
                double lat = location.getLatitude();

                try {
                    addresses = geocoder.getFromLocation(lat,lng,1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                address.setText("Address : "+addresses.get(0).getAddressLine(0));
                longitude.setText("Longitude : "+String.valueOf(lng));
                latitude.setText("Latitude : "+String.valueOf(lat));
                accuracy.setText("Accuracy : "+String.valueOf(location.getAccuracy()));
                altitude.setText("Altitude : "+String.valueOf(location.getAltitude()));
            }
        };

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        else
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
        }

        Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double lastKnownLng = lastKnownLocation.getLongitude();
        double lastKnownLat = lastKnownLocation.getLatitude();


        if(lastKnownLocation != null)
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0, locationListener);
            longitude.setText("Longitude : "+String.valueOf(lastKnownLng));
            latitude.setText("Latitude : "+String.valueOf(lastKnownLat));
            accuracy.setText("Accuracy : "+String.valueOf(lastKnownLocation.getAccuracy()));
            altitude.setText("Altitude : "+String.valueOf(lastKnownLocation.getAltitude()));

            geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

            try {
                LastKnownaddresses = geocoder.getFromLocation(lastKnownLat,lastKnownLng,1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            address.setText("Address : "+LastKnownaddresses.get(0).getAddressLine(0));

        }

    }
}