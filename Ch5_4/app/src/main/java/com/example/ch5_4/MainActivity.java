package com.example.ch5_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public  boolean onKeyDown(int keycode, KeyEvent event)
    {
        if (keycode == KeyEvent.KEYCODE_BACK)
        {
            EditText txtInput = (EditText) findViewById(R.id.txtInput);

            txtInput.setText("按下BACK按鍵");
            return  true;
        }
        return  super.onKeyDown(keycode,event);


    }

    @Override
    public  boolean onKeyUp(int keycode, KeyEvent event)
    {
        TextView output=(TextView) findViewById(R.id.lblOutput);
        output.setText("按下按鍵碼:"+keycode);
        return  super.onKeyUp(keycode,event);

    }
}