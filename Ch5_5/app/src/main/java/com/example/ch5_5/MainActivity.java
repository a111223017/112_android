package com.example.ch5_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txvoutput = (TextView) findViewById(R.id.txvOutput);
        txvoutput.setTextSize(25);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activity_main);
        layout.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        TextView txvoutput = (TextView) findViewById(R.id.txvOutput);
        int act = event.getAction();
        switch (act)
        {
            case  MotionEvent.ACTION_DOWN:
                txvoutput.setText("ACTION_DOWN");
                txvoutput.setTextColor(Color.RED);
                break;
            case  MotionEvent.ACTION_UP:
                txvoutput.setText("ACTION_UP");
                txvoutput.setTextColor(Color.GREEN);
                break;
            case  MotionEvent.ACTION_MOVE:
                float x =event.getX();
                float y = event.getY();
                txvoutput.setText("X="+x+"\n Y = "+y);

                txvoutput.setTextColor(Color.BLUE);
                break;
        }
        return false;
    }
}