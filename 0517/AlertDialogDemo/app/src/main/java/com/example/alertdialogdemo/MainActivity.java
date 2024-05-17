package com.example.alertdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private  String[] items = {"Samsun","OPPO","Apple","Asus"};
    private  boolean[] itchecked = {true,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAbout  = (Button) findViewById(R.id.BtnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("關於本書")
                        .setMessage("Android 程式設計與應用 \n 作者: 陳會安 \n 教師: 恰克虎")
                        .setCancelable(true)
                        .setPositiveButton("關於本書",null)
                        .show();

            }
        });
        Button btnExit  = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("確認")
                        .setMessage("你確定要結束這個程式嗎")

                        .setPositiveButton("確定",MainActivity.this)
                        .setNegativeButton("取消",MainActivity.this)
                        .show();
            }
        });
        Button btnColor = (Button) findViewById(R.id.btnColor);
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("選擇一個顏色")
                        .setItems(new String[]{"紅色", "黃色", "綠色"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Button btnColor = (Button) findViewById(R.id.btnColor);
                                switch (which) {
                                    case 0:
                                        btnColor.setBackgroundColor(Color.RED);
                                        break;
                                    case 1:
                                        btnColor.setBackgroundColor(Color.YELLOW);
                                        break;
                                    case  2:
                                        btnColor.setBackgroundColor(Color.GREEN);
                                        break;

                                }
                            }
                        })

                        .setNegativeButton("取消",MainActivity.this)
                        .show();
            }
        });
        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("請勾選選項")
                        .setPositiveButton("確定",MainActivity.this)
                        .setNegativeButton("取消",MainActivity.this)
                        .setMultiChoiceItems(items, itchecked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                String msg = "";
                                TextView txv = (TextView) findViewById(R.id.txv);
                                switch (which)
                                {
                                    case DialogInterface.BUTTON_POSITIVE:
                                        for(int index = 0 ;index < items.length ; index++)
                                        {
                                            if(itchecked[index])
                                            {
                                                msg +=items[index]+"\n";
                                            }


                                        }
                                        txv.setText(msg);
                                        break;
                                    case DialogInterface.BUTTON_NEGATIVE:
                                        Toast.makeText(MainActivity.this, "按下取消鍵", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
//        switch (which) {
//            case DialogInterface.BUTTON_POSITIVE:
//                finish();
//                break;
//            case DialogInterface.BUTTON_NEGATIVE:
//                Toast.makeText(this, "按下取消鍵", Toast.LENGTH_SHORT).show();
//                break;
//
//
//        }
//        Button btnColor = (Button) findViewById(R.id.btnColor);
//        switch (which) {
//            case 0:
//                btnColor.setBackgroundColor(Color.RED);
//                break;
//            case 1:
//                btnColor.setBackgroundColor(Color.YELLOW);
//                break;
//            case  2:
//                btnColor.setBackgroundColor(Color.GREEN);
//                break;
//
//        }
        String msg = "";
        TextView txv = (TextView) findViewById(R.id.txv);
        switch (which)
        {
            case DialogInterface.BUTTON_POSITIVE:
                for(int index = 0 ;index < items.length ; index++)
                {
                    if(itchecked[index])
                    {
                        msg +=items[index]+"\n";
                    }


                }
                txv.setText(msg);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this, "按下取消鍵", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}