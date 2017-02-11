package map92.iii.org.tw.appgooglemap;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

import JavaBean.InjectStation;
import JavaBean.InjectionStationKHH;
import JavaBean.object_MapMarkData;
import cz.msebera.android.httpclient.Header;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Callback;
import okhttp3.Response;
import com.loopj.android.http.*;


public class ActMain extends AppCompatActivity {
    ArrayList<InjectionStationKHH> injectionStationKHHList = new ArrayList<>();
    ArrayList<InjectStation> injectStationList = new ArrayList<>();
    ArrayList<String> stationNameList;
    ArrayList<String> stationPhoneList;
    ArrayList<String> stationAddressList;
    OkHttpClient client = new OkHttpClient();
    InjectStation injectStop = new InjectStation();
    CountDownLatch l_CountDownLatch;
    ArrayList<object_MapMarkData> l_arrayList_object_MapMarkData;

    Gson gson = new Gson();
    String url = "http://twpetanimal.ddns.net:9487/api/v1/maps";
    AsyncHttpClient loopjClient = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
          l_CountDownLatch = new CountDownLatch(1);


        //LatLng gpsKHS = new LatLng(22.6285339,120.2930492);    //設定經緯度
        final GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();   //取得地圖

        //Marker l_markKHStation = map.addMarker(new MarkerOptions().position(gpsKHS).title("我的位置").snippet("")); //設地標
        //map.moveCamera( CameraUpdateFactory.newLatLngZoom(gpsKHS, 16) );      //設定顯示大小

        loopjClient.get(ActMain.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);
                Log.d("Debug", "" + responsestr);
                  l_arrayList_object_MapMarkData = gson.fromJson(responsestr, new TypeToken<ArrayList<object_MapMarkData>>() {
                }.getType());
                Log.d("Debug", "" + l_arrayList_object_MapMarkData.get(0).getMaplatitude());

                // map.moveCamera( CameraUpdateFactory.newLatLngZoom(gps, 16) );      //設定顯示大小
                l_CountDownLatch.countDown();
                Log.d("Debug22", "" + l_arrayList_object_MapMarkData.get(0).getMaplatitude());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Debug", "" + error);
            }
        });

        final Thread l_thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    l_CountDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (final object_MapMarkData obj : l_arrayList_object_MapMarkData
                        ) {
                    Log.d("Debug1", "" + obj.getMaplatitude());
                    if(obj.getMaplatitude()!=null){
                        final LatLng gps = new LatLng(Double.valueOf(obj.getMaplatitude()), Double.valueOf(obj.getMaplongitude()));

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Marker marker = map.addMarker(new MarkerOptions().position(gps)
                                        .title(obj.getMapName())
                                        .snippet(obj.getMapContent())
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.dog_icon))); //設地標
                            }
                        });

                    }

                }
            }
        });

        l_thread.start();
        LatLng gps = new LatLng(22.628228, 120.2908483);    //設定經緯度 預設南區資策會
        Marker marker = map.addMarker(new MarkerOptions().position(gps).title("南區資策會").snippet("")); //設地標
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(gps, 16));      //設定顯示大小

        //Log.d("Debug", "" + l_arrayList_object_MapMarkData.get(0).getMaplatitude());

    }
}
