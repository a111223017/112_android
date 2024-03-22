package com.example.bmi_a111223017;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  TextView txvshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvshow = (TextView)findViewById(R.id.txtview);
        txvshow.setTextSize(36);
        Button btncalc = (Button)findViewById(R.id.btnCalk);
        Button btnclear = (Button) findViewById(R.id.btnClear);
        btncalc.setOnClickListener(this);//取得監聽的聯繫
        btnclear.setOnClickListener(this);


    }

    public void onClick(View v)//誰呼叫的

    {

        EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);

        if(v.getId() == R.id.btnCalk)
        {
         double height = Double.parseDouble(edtHeight.getText().toString());
         double weight = Double.parseDouble(edtWeight.getText().toString());
         double bmi = weight/Math.pow(height/100.0,2);
         if(bmi>=24)
         {
             txvshow.setTextColor(Color.RED);
             txvshow.setTextSize(48);
         }
         else  if(bmi<18.5)
         {
             txvshow.setTextColor(Color.BLUE);
             txvshow.setTextSize(36);

         }
         else
         {
             txvshow.setTextSize(36);
             txvshow.setTextColor(Color.GREEN);
         }

        txvshow.setText(String.format("%.2f",bmi));
        }
        else
        {
            edtWeight.setText("0");
            edtHeight.setText("0" );
            txvshow.setText("" );

        }


    }
}