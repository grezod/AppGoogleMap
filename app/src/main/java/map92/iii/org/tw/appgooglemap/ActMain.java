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

import JavaBean.InjectStation;
import JavaBean.InjectionStationKHH;
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

    Gson gson = new Gson();
    String url ="http://data.kcg.gov.tw/api/action/datastore_search?resource_id=b5d645b6-b7a5-46a3-98b1-993f14dbd1a3";
    AsyncHttpClient loopjClient = new AsyncHttpClient();

    InjectionStationKHH item1 = new InjectionStationKHH("一嘉動物醫院","07-3318123","80243","高雄市苓雅區興中一路383號");
    InjectionStationKHH item2 = new InjectionStationKHH("人人動物醫院","07-7830515","83154","高雄市大寮區鳳林三路827號");
    InjectionStationKHH item3 = new InjectionStationKHH("人愛動物醫院","07-2371276","80048","高雄市新興區六合一路30號");
    InjectionStationKHH item4 = new InjectionStationKHH("十銓動物醫院","07-3113797","80752","高雄市三民區十全二路99號");
    InjectionStationKHH item5 = new InjectionStationKHH("三和台大動物醫院","07-3383828","80253","高雄市苓雅區光華一路23號");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        injectionStationKHHList.add(item1);
        injectionStationKHHList.add(item2);
        injectionStationKHHList.add(item3);
        injectionStationKHHList.add(item4);
        injectionStationKHHList.add(item5);

        //LatLng gpsKHS = new LatLng(22.6285339,120.2930492);    //設定經緯度
        final GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();   //取得地圖

        //Marker l_markKHStation = map.addMarker(new MarkerOptions().position(gpsKHS).title("我的位置").snippet("")); //設地標
        //map.moveCamera( CameraUpdateFactory.newLatLngZoom(gpsKHS, 16) );      //設定顯示大小

        loopjClient.get(ActMain.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);
                Log.d("Debug",""+responsestr);
                injectStop = gson.fromJson(responsestr,InjectStation.class);
                Log.d("Debug",""+injectStop);
                //**
                Thread l_Thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(final InjectStation.ResultBean.RecordsBean rb: injectStop.getResult().getRecords()){
                            String strAddress = rb.get機構地址().trim();
                            if (strAddress != null) {
                                Geocoder geoCoder = new Geocoder(ActMain.this, Locale.TRADITIONAL_CHINESE);
                                List<Address> addressLocation = null;
                                try {
                                    addressLocation = geoCoder.getFromLocationName(strAddress, 1);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if(addressLocation.size() > 0){
                                    double latitude = addressLocation.get(0).getLatitude();
                                    double longitude = addressLocation.get(0).getLongitude();
                                    final LatLng gps = new LatLng(latitude,longitude);    //設定經緯度

                                    //**
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Marker marker = map.addMarker(new MarkerOptions().position(gps)
                                                    .title(rb.get機構名稱())
                                                    .snippet(rb.get機構電話())
                                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.dog_icon))); //設地標
                                           // map.moveCamera( CameraUpdateFactory.newLatLngZoom(gps, 16) );      //設定顯示大小
                                        }
                                    });
                                    //**


                                }
                            } else {
                                Toast.makeText(ActMain.this, "無資料可顯示", Toast.LENGTH_LONG).show();
                            }
                        }

                    }
                });
                l_Thread.start();
                //**


                LatLng gps = new LatLng(22.628228,120.2908483);    //設定經緯度 預設南區資策會
                Marker marker = map.addMarker(new MarkerOptions().position(gps).title("南區資策會").snippet("")); //設地標
                map.moveCamera( CameraUpdateFactory.newLatLngZoom(gps, 16) );      //設定顯示大小
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("Debug",""+error);
            }
        });




//        for(InjectionStationKHH inject : injectionStationKHHList){
//            String strAddress = inject.getAddress().trim();
//            if (strAddress != null) {
//                Geocoder geoCoder = new Geocoder(ActMain.this, Locale.TRADITIONAL_CHINESE);
//                List<Address> addressLocation = null;
//                try {
//                    addressLocation = geoCoder.getFromLocationName(strAddress, 1);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                double latitude = addressLocation.get(0).getLatitude();
//                double longitude = addressLocation.get(0).getLongitude();
//
//                LatLng gps = new LatLng(latitude,longitude);    //設定經緯度
//                Marker marker = map.addMarker(new MarkerOptions().position(gps).title(inject.getName()).snippet("")); //設地標
//                map.moveCamera( CameraUpdateFactory.newLatLngZoom(gps, 14) );      //設定顯示大小
//
//            } else {
//                Toast.makeText(ActMain.this, "請輸入地址", Toast.LENGTH_LONG).show();
//            }
//        }

    }

}
