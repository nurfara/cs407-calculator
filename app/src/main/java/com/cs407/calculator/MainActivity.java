package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText firstNum, secondNum;
    Button plusButton, minusButton, multiplyButton, divideButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = findViewById(R.id.firstNum);
        secondNum = findViewById(R.id.secondNum);

        plusButton = findViewById(R.id.plusButton);
        minusButton = findViewById(R.id.minusButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity('+');
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if secondNum is 0 or not
                int num2 = Integer.parseInt(secondNum.getText().toString());
                if (num2 != 0) {
                    openResultActivity('/');
                } else {
                    // TODO handle div by 0 here. error message.
                }
            }
        });

    }

    private void openResultActivity(char operation) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("num1", Integer.parseInt(firstNum.getText().toString()));
        intent.putExtra("num2", Integer.parseInt(secondNum.getText().toString()));
        intent.putExtra("operation", operation);
        startActivity(intent);
    }

}