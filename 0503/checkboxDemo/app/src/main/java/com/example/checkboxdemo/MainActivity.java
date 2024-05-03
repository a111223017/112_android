package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private CheckBox Chkoriginal, Chkbeef, ChkSeafood;
    private TextView output;
    private int[] ChkIds = {R.id.chkOriginal, R.id.chkBeef, R.id.chkSeafood};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chkoriginal = (CheckBox) findViewById(R.id.chkOriginal);
        Chkbeef = (CheckBox) findViewById(R.id.chkBeef);
        ChkSeafood = (CheckBox) findViewById(R.id.chkSeafood);

        output = (TextView) findViewById(R.id.lblOutput);

        Button btnConfirm = (Button) findViewById(R.id.buttonconfirm);
        for (int id : ChkIds) {
            CheckBox chk = (CheckBox) findViewById(id);
            chk.setOnCheckedChangeListener(this);

        }

//        btnConfirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String str = "";
//                if(Chkoriginal.isChecked())
//                {
//                    str+=Chkoriginal.getText()+"\n";
//
//                }
//                if(Chkbeef.isChecked())
//                {
//                    str+=Chkbeef.getText()+"\n";
//
//                }
//                if(ChkSeafood.isChecked())
//                {
//                    str+=ChkSeafood.getText()+"\n";
//
//                }
//                output.setText(str);
//
//            }
//        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        TextView txvStatus = (TextView) findViewById(R.id.txvStatus);
        int id = buttonView.getId();
        String str = "";
        String status = "";
        if (id == R.id.chkOriginal) {
            status = (isChecked ? "獲取" : "取消") + "原味...";

        } else if (id == R.id.chkBeef) {
            status = (isChecked ? "獲取" : "取消") + "牛肉...";
        } else if (id == R.id.chkSeafood) {
            status = (isChecked ? "獲取" : "取消") + "海鮮...";
        }
        txvStatus.setText(status);
        showResult();
    }

    public void showResult()
    {
        String str = "";
        for (int id : ChkIds) {
            CheckBox chk = (CheckBox) findViewById(id);
            if(chk.isChecked())
                str +=chk.getText()+"\n";

        }
        output.setText(str);


    }
}