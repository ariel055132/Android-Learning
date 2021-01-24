## Maps

1. How to work with maps in our Apps
    * at least API 23: Android 6.0
    * Select Google Maps Activity
    * a new project with a map inside the app is created
    * connect and make an API key with Google Maps (**google_maps_api.xml**)
    * Write your code in **MapsActivity.java**
    * The original code in MapsActivity.java in the below
    *   ```java
        package com.example.mapfun;

        import androidx.fragment.app.FragmentActivity;

        import android.os.Bundle;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

        public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

            private GoogleMap mMap;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_maps);
                // Obtain the SupportMapFragment and get notified when the map is ready to be used. (in the background)
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);
            }

            /**
            * Manipulates the map once available.
            * This callback is triggered when the map is ready to be used.
            * This is where we can add markers or lines, add listeners or move the camera. In this case,
            * we just add a marker near Sydney, Australia.
            * If Google Play services is not installed on the device, the user will be prompted to install
            * it inside the SupportMapFragment. This method will only be triggered once the user has
            * installed Google Play services and returned to the app.
            */
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                // Add a marker in Sydney and move the camera (Red Pin)
                // Add the marker to Google Map and move the camera
                LatLng sydney = new LatLng(-34, 151);
                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }
        }
        ```
    * You can add components to the map in activity_maps.xml

2. Customizing Your Maps
    1. put something in a new location
    2. find the location 
    3. change our maps (e.g show a satellite image)
   
    * Example
        ```java
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            // Add the marker to Google Map and move the camera
            LatLng mt_everest = new LatLng(27.989445399347503, 86.92523243954005);
            // Change the marker from red to yellow
            mMap.addMarker(new MarkerOptions().position(mt_everest).title("mt_everest").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

            mMap.moveCamera(CameraUpdateFactory.newLatLng(mt_everest));
        }
        ```