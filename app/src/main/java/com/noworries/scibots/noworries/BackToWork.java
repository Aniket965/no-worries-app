package com.noworries.scibots.noworries;

import android.Manifest;
import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by aniket sharma on 11-03-2017.
 */

public class BackToWork extends IntentService {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    public BackToWork() {
        this(BackToWork.class.getName());

    }


    public BackToWork(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("yo aniket is cool :", "Service Started!");
        showToast("Starting IntentService");

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            LocationListener locationListener = new MylocationListner();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                //code that runs when timer is done
                Log.d("fuck off----", "still fuck off");

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("9899023974", null, "aniket is cool boy", null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();

                } else {

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("9899023974", null, "aniket is cool boy", null, null);

                }

                NotificationCompat.Builder mbuilder =  new
                        NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.mipmap.ic_launcher).setContentTitle("title")
                        .setContentText("aniket is cooler now");

                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotifyMgr.notify(001,mbuilder.build());
            }
        }, 1000*60);

    }
    protected void showToast(final String msg){
        //gets the main thread
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                // run this code in the main thread
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
