package com.example.lifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private  final String TAG = "LifeCycleTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"OnCrate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected  void  onStart() {

        Log.v(TAG, "OnStart");
        super.onStart();

    }
    @Override
    protected  void  onRestart() {

        Log.v(TAG, "OnRestart");
        super.onRestart();

    }
    @Override
    protected  void  onResume() {
        Log.v(TAG, "OnResume");
        super.onResume();

    }
    @Override
    protected  void  onPause() {

        Log.v(TAG, "OnPause");
        super.onPause();
    }
    @Override
    protected  void  onStop() {

        Log.v(TAG, "OnStop");
        super.onStop();
    }
    @Override
    protected  void onDestroy() {

        Log.v(TAG,"OnDestory");
        super.onDestroy();
    }

}