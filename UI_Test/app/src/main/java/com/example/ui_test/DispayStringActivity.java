package com.example.ui_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DispayStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dispay_string);

        TextView txvshow = (TextView) findViewById(R.id.txvShow);//先定義找出來
        Intent intent = getIntent();
        String reveivedString = intent.getStringExtra("userInput");//收傳送過來的字串
        txvshow.setText(reveivedString+"您好");

    }
}