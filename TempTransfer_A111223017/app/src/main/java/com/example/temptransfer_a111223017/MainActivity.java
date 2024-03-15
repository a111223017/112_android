package com.example.temptransfer_a111223017;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void  Button_click(View view)
    {
        EditText edtTemp = (EditText)findViewById(R.id.edtTemp);//建立關聯
        TextView txvShow = (TextView)findViewById(R.id.txvShow);
        double drgreec = Double.parseDouble(edtTemp.getText().toString());
        double degreeF = (9.0*drgreec)/5.0+32.0;

        txvShow.setText("華氏溫度 :"+String.format("%.2f",degreeF));
    }
}