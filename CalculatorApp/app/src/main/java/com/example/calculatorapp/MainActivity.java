package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //숫자 패드 버튼 변수 선언
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private Button Button7;
    private Button Button8;
    private Button Button9;
    private Button Button0;

    //그 외 계산 버튼 변수 선언
    private Button Button_point;
    private Button Button_equal;
    private Button Button_erase;
    private Button Button_divide;
    private Button Button_multiple;
    private Button Button_minus;
    private Button Button_plus;

    //TextView 변수 선언 (input & result)
    private TextView inputText;
    private TextView resultText;

    //그 외 변수
    private boolean Number_turn = false;
    private boolean Isfirst = true;
    private boolean startCalculate_show = false;
    private String value = "";
    private String operator = "+";
    private double result = 0.0;
    private double result_instant = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //숫자 패드 버튼 변수 설정
        Button0 = (Button)findViewById(R.id.button0);
        Button1 = (Button)findViewById(R.id.button1);
        Button2 = (Button)findViewById(R.id.button2);
        Button3 = (Button)findViewById(R.id.button3);
        Button4 = (Button)findViewById(R.id.button4);
        Button5 = (Button)findViewById(R.id.button5);
        Button6 = (Button)findViewById(R.id.button6);
        Button7 = (Button)findViewById(R.id.button7);
        Button8 = (Button)findViewById(R.id.button8);
        Button9 = (Button)findViewById(R.id.button9);

        //그 외 계산 버튼 변수 설정
        Button_point = (Button)findViewById(R.id.button_point);
        Button_equal = (Button)findViewById(R.id.button_equal);
        Button_erase = (Button)findViewById(R.id.button_erase);
        Button_divide = (Button)findViewById(R.id.button_divide);
        Button_multiple = (Button)findViewById(R.id.button_multiple);
        Button_minus = (Button)findViewById(R.id.button_minus);
        Button_plus = (Button)findViewById(R.id.button_plus);

        //TextView 변수 설정 (input & result)
        inputText = (TextView)findViewById(R.id.inputText);
        resultText = (TextView)findViewById(R.id.resultText);


        //버튼 클릭 이벤트 내용 설정
        View.OnClickListener mClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //input text가 비워져있는 상태인지 확인
                if(inputText.getText().toString().isEmpty()){
                    Isfirst =true;
                }


                //처음 버튼 클릭 조건 체크
                if(Isfirst){
                    if(!CheckFirstClick(v)) return;
                 }

                //버튼 클릭 이벤트
                if(v == Button0){
                    if(Number_turn) Number_turn = false;
                    value += "0";
                    inputText.setText(inputText.getText().toString() + 0);
                }
                else if(v == Button1){
                    if(Number_turn) Number_turn = false;
                    value += "1";
                    inputText.setText(inputText.getText().toString() + 1);
                }
                else if(v == Button2){
                    if(Number_turn) Number_turn = false;
                    value += "2";
                    inputText.setText(inputText.getText().toString() + 2);
                }
                else if(v == Button3){
                    if(Number_turn) Number_turn = false;
                    value += "3";
                    inputText.setText(inputText.getText().toString() + 3);
                }
                else if(v == Button4){
                    if(Number_turn) Number_turn = false;
                    value += "4";
                    inputText.setText(inputText.getText().toString() + 4);
                }
                else if(v == Button5){
                    if(Number_turn) Number_turn = false;
                    value += "5";
                    inputText.setText(inputText.getText().toString() + 5);
                }
                else if(v == Button6){
                    if(Number_turn) Number_turn = false;
                    value += "6";
                    inputText.setText(inputText.getText().toString() + 6);
                }
                else if(v == Button7){
                    if(Number_turn) Number_turn = false;
                    value += "7";
                    inputText.setText(inputText.getText().toString() + 7);
                }
                else if(v == Button8){
                    if(Number_turn) Number_turn = false;
                    value += "8";
                    inputText.setText(inputText.getText().toString() + 8);
                }
                else if(v == Button9){
                    if(Number_turn) Number_turn = false;
                    value += "9";
                    inputText.setText(inputText.getText().toString() + 9);
                }
                else if(v == Button_point){
                    if(!Number_turn){
                        inputText.setText(inputText.getText().toString() + ".");
                        Number_turn = true;
                    }
                }
                else if(v == Button_equal){
                    inputText.setText(resultText.getText());
                    resultText.setText("");
                    startCalculate_show = false;
                }
                else if(v == Button_erase){
                    if(inputText.getText().toString().isEmpty()) return;
                    Isfirst = true;
                    startCalculate_show = false;
                    result = 0;
                    result_instant = 0;
                    operator = "+";
                    value = "";
                    inputText.setText("");
                    resultText.setText("");
                }
                else if(v == Button_divide){
                    if(!Number_turn){
                        inputText.setText(inputText.getText().toString() + "/");
                        operator = "/";
                        Number_turn = true;
                    }

                }
                else if(v == Button_multiple){
                    if(!Number_turn){
                        inputText.setText(inputText.getText().toString() + "*");
                        operator = "*";
                        Number_turn = true;
                    }

                }
                else if(v == Button_minus){
                    if(!Number_turn){
                        inputText.setText(inputText.getText().toString() + "-");
                        operator = "-";
                        Number_turn = true;
                    }

                }
                else if(v == Button_plus){
                    if(!Number_turn){
                        inputText.setText(inputText.getText().toString() + "+");
                        operator = "+";
                        Number_turn = true;
                    }
                }

                if(Number_turn && !Isfirst) {
                    value = "";
                    result = result_instant;
                    startCalculate_show = true;

                }

                if(!value.isEmpty()){
                    switch (operator){
                        case "+":
                            result_instant = result + Integer.parseInt(value);
                            break;
                        case "-":
                            result_instant = result - Integer.parseInt(value);
                            break;
                        case "*":
                            result_instant = result * Integer.parseInt(value);
                            break;
                        case "/":
                            result_instant = result / Integer.parseInt(value);
                            break;
                    }
                }

                if(startCalculate_show){
                    resultText.setText(Double.toString(result_instant));
                }



            }

        };


        //Button ClickListener 설정
        Button0.setOnClickListener(mClickListener);
        Button1.setOnClickListener(mClickListener);
        Button2.setOnClickListener(mClickListener);
        Button3.setOnClickListener(mClickListener);
        Button4.setOnClickListener(mClickListener);
        Button5.setOnClickListener(mClickListener);
        Button6.setOnClickListener(mClickListener);
        Button7.setOnClickListener(mClickListener);
        Button8.setOnClickListener(mClickListener);
        Button9.setOnClickListener(mClickListener);
        Button_point.setOnClickListener(mClickListener);
        Button_equal.setOnClickListener(mClickListener);
        Button_erase.setOnClickListener(mClickListener);
        Button_divide.setOnClickListener(mClickListener);
        Button_multiple.setOnClickListener(mClickListener);
        Button_minus.setOnClickListener(mClickListener);
        Button_plus.setOnClickListener(mClickListener);




    }


    public boolean CheckFirstClick(View view){
        if(view == Button_point || view == Button_equal || view == Button_erase
         || view == Button_divide || view == Button_multiple){
            return false;
        }
        if(view == Button_plus || view == Button_minus)  return true;
        if(!Number_turn) Isfirst = false;
        return true;

    }
}
