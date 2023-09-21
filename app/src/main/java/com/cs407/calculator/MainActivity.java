package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFunction(View view) {
        EditText firstNum = findViewById(R.id.firstNum);
        EditText secondNum = findViewById(R.id.secondNum);
        String firstNumStr = firstNum.getText().toString();
        String secondNumStr = secondNum.getText().toString();
        if (!firstNumStr.isEmpty() && !secondNumStr.isEmpty()) {
            int num1 = Integer.parseInt(firstNumStr);
            int num2 = Integer.parseInt(secondNumStr);

            switch(view.getId()) {
             //   case R.id.plusButton: //FIXME
              //      break;
            }
        }
    }


}