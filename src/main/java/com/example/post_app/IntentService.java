package com.example.post_app;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class IntentService extends android.app.IntentService {

    private final static String TAG = "com.example.post_app";
 public IntentService(){
     super("IntentService");
 }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
     Log.i(TAG,"Download Started");
    }
}
