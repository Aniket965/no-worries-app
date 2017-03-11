package com.noworries.scibots.noworries;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by aniket sharma on 11-03-2017.
 */

public class BackToWork extends IntentService {
    public  BackToWork(){
        this(BackToWork.class.getName());

    }


    public BackToWork(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("yo aniket is cool :", "Service Started!");
        showToast("Starting IntentService");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            showToast("Finishing IntentService");
            Log.d("yo aniket is cool :", "Service ended!");
        }

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
