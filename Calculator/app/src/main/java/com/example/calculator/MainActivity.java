package com.example.calculator;


import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//bmi沒辦法除0x0 的另外狀況
//改計算機的style 按鈕 加分 可以額外處理小數的運算 浮點數的運算

enum State {FirstNumberInput, OperatorInputed, NumberInput, DecimalInput}
enum OP { None, Add, Sub, Mul, Div,Dec}

public class MainActivity extends AppCompatActivity {
    private int theValue = 0;
    private double thedValue = 0;
    private String tempDecimalInput = "",tempinput="",tempinput2="";
    private  double thedobvalue = 0;
    private int operand1 = 0, operand2 = 0;
    private double doperand1 = 0, doperand2 = 0;
    private OP op=OP.None;
    private State state = State.FirstNumberInput;

    private  int doublenum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void onWindowFocusChanged (boolean hasFocus) {
        GridLayout keysGL = (GridLayout) findViewById(R.id.keys);

        int kbHeight = (int) (keysGL.getHeight() / keysGL.getRowCount());
        int kbWidth = (int) (keysGL.getWidth()/keysGL.getColumnCount());

        Button btn;

        for( int i=0; i< keysGL.getChildCount();i++){
            btn = (Button) keysGL.getChildAt(i);
            btn.setHeight(kbHeight);
            btn.setWidth(kbWidth);
            btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36 );
        }
    }
    public void processKeyInput(View view){
        tempDecimalInput = "";

        Button b= (Button )view;    // 取得發生事件的按鈕
        String bstr= b.getText().toString();   // 取得發生事件的按鈕上的文字
        int bint; // 透過R.id.display取得顯示結果的EditText元件
        EditText edt = (EditText) findViewById(R.id.display);


        switch(bstr) { // 依據發生事件的按鈕上的文字值，進行不同的處理
            // 數字按鈕被點按時
            case ".":

                tempinput+=".";
                edt.setText("" + tempinput);
                break;
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":

                bint = Integer.parseInt(bstr);
                double bdouble = (double)bint;


                switch(state) { // 依據當時的狀態決定不同的處理
                    case FirstNumberInput:
                        tempinput+=bstr;
                        break;
                    case OperatorInputed:
                        theValue=bint;
                        operand2=bint;
                        state=State.NumberInput;
                        break;
                    case NumberInput:
                        tempinput+=bstr;

                        break;
                    case  DecimalInput:
                        tempinput+=bstr;
                        break;


                }
                edt.setText("" + tempinput);
                break;


            case "Clear": // 清除並重設相關變數
                tempinput="";
                state=State.FirstNumberInput;
                theValue=0;
                edt.setText((CharSequence)("0"));
                op=OP.None;
                operand2=operand1=0;
                break;
            case "Back": // 倒退鍵
                StringBuilder bcaknumber = new StringBuilder(tempinput);
                bcaknumber.deleteCharAt(bcaknumber.length() - 1);
                String result = bcaknumber.toString();
                tempinput =result;
                theValue=(int)(theValue/10);
                edt.setText("" + tempinput);
                break;
            case "+":
            case "-":
            case "*":
            case "/": // 當operator被點選時
                switch(bstr) {
                            case "+": op=OP.Add; break;
                            case "-": op=OP.Sub; break;
                            case "*": op=OP.Mul; break;
                            case "/": op=OP.Div; break;
                }

                    tempinput2=tempinput;
                    tempinput="";
                    edt.setText("" + tempinput);







            case "=": // 當＝號被點選時，依據當時的狀態決定不同的處理
                if(isInteger(tempinput)&&isInteger(tempinput2))
                {
                    operand1=Integer.parseInt(tempinput2);
                    operand2=Integer.parseInt(tempinput);
                    switch(op) {
                        case Add: theValue=operand1+operand2; break;
                        case Sub: theValue=operand1-operand2; break;
                        case Mul: theValue=operand1*operand2; break;
                        case Div: theValue=operand1/operand2; break;

                    }
                    edt.setText("" + theValue);
                    tempinput="" +theValue;
                } else if (isEmpty(tempinput)&&isEmpty(tempinput2)) {
                    doperand1=Double.parseDouble(tempinput2);
                    doperand2=Double.parseDouble(tempinput);
                    switch(op) {
                        case Add: thedValue=doperand1+doperand2; break;
                        case Sub: thedValue=doperand1-doperand2; break;
                        case Mul: thedValue=doperand1*doperand2; break;
                        case Div: thedValue=doperand1/doperand2; break;

                    }
                    edt.setText("" + thedValue);
                    tempinput="" +thedValue;
                }



                break;
        }
    }
    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isEmpty(String str) {
        // 如果字符串的长度为0，则返回 true；否则返回 false
        if (str.length() == 0)
        {
            return false;
        }
        else
        {

            return true ;
        }
    }
}
