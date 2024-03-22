package com.example.ui_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ui_test2.DispayStringActivity;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

        public void btn_sendString(View view)
        {
            EditText edtInput = (EditText) findViewById(R.id.edtInput);
            String string2send = edtInput.getText().toString();

            Intent intent = new Intent(this, DispayStringActivity.class);
            intent.putExtra("userInput", string2send);   //呼叫資料並傳算過去
            startActivity(intent);

        }

}