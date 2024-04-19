package com.example.radiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputStr="";
                RadioButton rbBoy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton rbGirl = (RadioButton) findViewById(R.id.rdbGirl);
                if (rbBoy.isChecked())
                {
                    outputStr +=getResources().getString(R.string.male)+"\n";
                }
                else if (rbGirl.isChecked())
                {
                    outputStr +=getResources().getString(R.string.female)+"\n";

                }
                RadioGroup rgtype = (RadioGroup) findViewById(R.id.rgType);
                if(rgtype.getCheckedRadioButtonId()==R.id.rdbAdult)
                {
                    outputStr +=getResources().getString(R.string.regularticket)+"\n";

                }
                else  if (rgtype.getCheckedRadioButtonId()==R.id.rdbChild)
                {
                    outputStr +=getResources().getString(R.string.childticket)+"\n";
                }
               else
                {
                    outputStr +=getResources().getString(R.string.studentticket)+"\n";

                }
                TextView lbloutput = (TextView) findViewById(R.id.lblOutput);
                lbloutput.setText(outputStr);
            }


        });
    }
    public void button_Click(View view) {
        String str = "";
        // 取得性別
        RadioButton boy = (RadioButton) findViewById(R.id.rdbBoy);
        if (boy.isChecked())
            str += "男\n";
        RadioButton girl = (RadioButton) findViewById(R.id.rdbGirl);
        if (girl.isChecked())
            str += "女\n";
        // 取得門票種類
        RadioGroup type = (RadioGroup) findViewById(R.id.rgType);
        if (type.getCheckedRadioButtonId() == R.id.rdbAdult)
            str += "全票\n";
        else if (type.getCheckedRadioButtonId() == R.id.rdbChild)
            str += "兒童票\n";
        else
            str += "學生票\n";
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText(str);
    }
}