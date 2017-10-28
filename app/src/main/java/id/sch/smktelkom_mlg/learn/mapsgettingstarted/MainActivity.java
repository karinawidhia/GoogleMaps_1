package id.sch.smktelkom_mlg.learn.mapsgettingstarted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204, -122.3491))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    MarkerOptions renton;
    MarkerOptions kirkland;
    MarkerOptions everett;
    MarkerOptions lynnwood;
    MarkerOptions montlake;
    MarkerOptions kent;
    MarkerOptions showare;
    GoogleMap m_map;
    Boolean mapReady = false;
    Button bMaps, bSat, bHy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*bMaps = (Button) findViewById(R.id.btnMap);
        bSat = (Button) findViewById(R.id.btnSat);
        bHy = (Button) findViewById(R.id.btnHyb);*/

        /*bMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    flyTo(SEATTLE);
            }
        });

        bSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    //m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    flyTo(NEW_YORK);
            }
        });

        bHy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    flyTo(JKT);
//                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });*/

        renton = new MarkerOptions()
                .position(new LatLng(47.489805, -122.120502))
                .title("Renton")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hockey1600));
        kirkland = new MarkerOptions()
                .position(new LatLng(47.7301986, -122.1768858))
                .title("Kirkland")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hockey1600));
        everett = new MarkerOptions()
                .position(new LatLng(47.978748, -122.202001))
                .title("Everett")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hockey1600));
        lynnwood = new MarkerOptions()
                .position(new LatLng(47.819533, -122.32288))
                .title("Lynnwood")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hockey1600));
        montlake = new MarkerOptions()
                .position(new LatLng(47.7973733, -122.3281771))
                .title("Montlake Terrace")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hockey1600));
        kent = new MarkerOptions()
                .position(new LatLng(47.385938, -122.258212))
                .title("Kent Valley")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hockey1600));
        showare = new MarkerOptions()
                .position(new LatLng(47.38702, -122.23986))
                .title("Showare Center")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hockey1600));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        mapReady = true;
        m_map = googleMap;
        m_map.addMarker(renton);
        m_map.addMarker(kent);
        m_map.addMarker(showare);
        m_map.addMarker(kirkland);
        m_map.addMarker(everett);
        m_map.addMarker(lynnwood);
        m_map.addMarker(montlake);
        flyTo(SEATTLE);
        /*LatLng nganjuk = new LatLng(53.3478, 6.2597);
        m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        CameraPosition target = CameraPosition.builder().target(nganjuk).zoom(14).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));*/
    }
}
