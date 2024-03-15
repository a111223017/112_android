package com.example.edittextdemo_a111223017;

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
        EditText edtName = (EditText)findViewById(R.id.edtName);//建立關聯
        TextView txvShow = (TextView)findViewById(R.id.txvShow);
        String name = edtName.getText().toString(); //取得edtname的值和東西
        txvShow.setText("你的名子是:"+name);
    }
}