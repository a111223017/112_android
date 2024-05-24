package com.example.explicitlntentdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factivity2);

        converTemputer();

        Button btnReturn = (Button) findViewById(R.id.BtnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void converTemputer()
    {
        int c;
        double f = 8.0;
        String place =" ";
        Bundle bundle = this.getIntent().getExtras();
        if(bundle!=null)
        {
            c=bundle.getInt("TEMPC",0);
            f = (9.0*c)/5.0 + 32.0;
            place = bundle.getString("PLACE","");
            TextView output = (TextView) findViewById(R.id.lblOutput);
            output.setText(place+"\n 華氏溫度: " + Double.toString(f));
        }
    }
}