package com.example.counter_a111223017;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void bt_add_click(View view)
    {
    int count;
    TextView output= (TextView) findViewById(R.id.txtcounter);//找到txtview直傳回id
    count =Integer.parseInt(output.getText().toString());//傳成整數
    count++;
    output.setText(Integer.toString(count));//裡面必須是字串 把數字轉換成字串

    }
    public  void bt_zero_click(View view)
    {
        int count;
        TextView output= (TextView) findViewById(R.id.txtcounter);//找到txtview直傳回id

        output.setText(R.string.ini_value);//裡面必須是字串 把數字轉換成字串


    }
}