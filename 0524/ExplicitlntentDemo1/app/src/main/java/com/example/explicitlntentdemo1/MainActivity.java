package com.example.explicitlntentdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtc = (EditText) findViewById(R.id.txtC);
                int tempc = Integer.parseInt(txtc.getText().toString());
                EditText edtplaec = (EditText) findViewById(R.id.edtPlace);
                Intent intent = new Intent(MainActivity.this,FActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("TEMPC",tempc);
                bundle.putString("PLACE",edtplaec.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}