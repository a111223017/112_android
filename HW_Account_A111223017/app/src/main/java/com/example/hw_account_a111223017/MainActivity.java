package com.example.hw_account_a111223017;

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
        EditText edtAccount = (EditText)findViewById(R.id.edtaccount);//建立關聯
        EditText edtpassword = (EditText)findViewById(R.id.edtpassword);//建立關聯
        TextView txvShow = (TextView)findViewById(R.id.txvShow);
        String txtaccount = edtAccount.getText().toString();
        String txtpassword  =(edtpassword.getText().toString());
        if(txtaccount.contains("李逸晨") &&txtpassword.contains("111223017") )
        {

            txvShow.setText("登入成功");
        }
        else
        {
            txvShow.setText("登入失敗");
        }


    }
}