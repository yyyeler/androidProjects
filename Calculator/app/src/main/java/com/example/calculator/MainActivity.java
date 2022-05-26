package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
TextView Result2Screen,Result3Screen,Result4Screen;
Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPlus,btnMinus,btnMulti,btnDivide,btnEqual,btnDecPoint,btnClear,btnClearAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnDecPoint = findViewById(R.id.buttonDecPoint);
        btnPlus = findViewById(R.id.buttonPlus);
        btnMinus = findViewById(R.id.buttonMinus);
        btnMulti = findViewById(R.id.buttonMulti);
        btnDivide = findViewById(R.id.buttonDivide);
        btnEqual = findViewById(R.id.buttonEqual);
        btnClear = findViewById(R.id.buttonClear);
        btnClearAll = findViewById(R.id.buttonClearAll);
        Result2Screen =findViewById(R.id.ResultSecond);
        Result3Screen =findViewById(R.id.ResultThird);
        Result4Screen =findViewById(R.id.ResultFourth);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText("1");
                else Result4Screen.setText(Result4Screen.getText()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText("2");
                else Result4Screen.setText(Result4Screen.getText()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText("3");
                else Result4Screen.setText(Result4Screen.getText()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText("4");
                else Result4Screen.setText(Result4Screen.getText()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText("5");
                else Result4Screen.setText(Result4Screen.getText()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText("6");
                else Result4Screen.setText(Result4Screen.getText()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText("7");
                else Result4Screen.setText(Result4Screen.getText()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText("8");
                else Result4Screen.setText(Result4Screen.getText()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText("9");
                else Result4Screen.setText(Result4Screen.getText()+"9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Result4Screen.getText().toString().equals("0"))
                    Result4Screen.setText(Result4Screen.getText()+"0");
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result2Screen.setText("");
                Result3Screen.setText("");
                Result4Screen.setText("0");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newResult = Result4Screen.getText().toString();
                if(newResult.length()>0)
                {
                    newResult = newResult.substring(0, newResult.length() - 1);
                    Result4Screen.setText(newResult);
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Result3Screen.getText().toString().equals(""))
                {
                    double num1,num2;
                    num1 = Double.parseDouble(Result2Screen.getText().toString());
                    num2 = Double.parseDouble(Result4Screen.getText().toString());
                    String operator = Result3Screen.getText().toString();
                    Result2Screen.setText(getData(num1,num2,operator));
                    Result3Screen.setText("+");
                    Result4Screen.setText("0");

                }
                else
                {
                    Result2Screen.setText(Result4Screen.getText().toString());
                    Result3Screen.setText("+");
                    Result4Screen.setText("0");
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Result3Screen.getText().toString().equals(""))
                {
                    double num1,num2;
                    num1 = Double.parseDouble(Result2Screen.getText().toString());
                    num2 = Double.parseDouble(Result4Screen.getText().toString());
                    String operator = Result3Screen.getText().toString();
                    Result2Screen.setText(getData(num1,num2,operator));
                    Result3Screen.setText("-");
                    Result4Screen.setText("0");

                }
                else
                {
                    Result2Screen.setText(Result4Screen.getText().toString());
                    Result3Screen.setText("-");
                    Result4Screen.setText("0");
                }
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Result3Screen.getText().toString().equals(""))
                {
                    double num1,num2;
                    num1 = Double.parseDouble(Result2Screen.getText().toString());
                    num2 = Double.parseDouble(Result4Screen.getText().toString());
                    String operator = Result3Screen.getText().toString();
                    Result2Screen.setText(getData(num1,num2,operator));
                    Result3Screen.setText("*");
                    Result4Screen.setText("0");

                }
                else
                {
                    Result2Screen.setText(Result4Screen.getText().toString());
                    Result3Screen.setText("*");
                    Result4Screen.setText("0");
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Result3Screen.getText().toString().equals(""))
                {
                    double num1,num2;
                    num1 = Double.parseDouble(Result2Screen.getText().toString());
                    num2 = Double.parseDouble(Result4Screen.getText().toString());
                    String operator = Result3Screen.getText().toString();
                    Result2Screen.setText(getData(num1,num2,operator));
                    Result3Screen.setText("/");
                    Result4Screen.setText("0");

                }
                else
                {
                    Result2Screen.setText(Result4Screen.getText().toString());
                    Result3Screen.setText("/");
                    Result4Screen.setText("0");
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Result3Screen.getText().toString().equals(""))
                {
                    double num1,num2;
                    num1 = Double.parseDouble(Result2Screen.getText().toString());
                    num2 = Double.parseDouble(Result4Screen.getText().toString());
                    String operator = Result3Screen.getText().toString();
                    Result2Screen.setText("");
                    Result3Screen.setText("");
                    Result4Screen.setText(getData(num1,num2,operator));

                }
            }
        });

        btnDecPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = Result4Screen.getText().toString();
                if(result.equals(""))   Result4Screen.setText("0.");
                else if(!result.contains("."))     Result4Screen.setText(result+".");

            }
        });
    }

    public String getData(Double num1 ,Double num2 ,String operator)
    {
        String Result="";
        switch (operator)
        {
            case "+" :
                if((num1 + num2)%1==0){
                    int c;
                    c=(int)(num1 + num2);
                    Result = Integer.toString(c);
                }else Result = Double.toString(num1 + num2);
                break;
            case "-" :
                if((num1 - num2)%1==0){
                    int c;
                    c=(int)(num1 - num2);
                    Result = Integer.toString(c);
                }else Result = Double.toString(num1 - num2);
                break;
            case "*" :
                if((num1 * num2)%1==0){
                    int c;
                    c=(int)(num1 * num2);
                    Result = Integer.toString(c);
                }
                else
                {
                    DecimalFormat df1 = new DecimalFormat("#.####");
                    Double d1 = new Double(num1 * num2);
                    Result =  df1.format(d1);
                }
                break;
            case "/" :
                if((num1 / num2)%1==0){
                    int c;
                    c=(int)(num1 / num2);
                    Result = Integer.toString(c);
                }
                else
                {
                    DecimalFormat df2 = new DecimalFormat("#.####");
                    Double d2 = new Double(num1 / num2);
                    Result =  df2.format(d2);
                }
                break;
        }
        return Result;
    }

}