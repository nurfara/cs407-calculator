package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView resultText; // to show the result from the intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // get data from MainActivity
        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        char operation = intent.getCharExtra("operation", '+');
        resultText = (TextView)findViewById(R.id.resultText);
        double result = calcResult(num1, num2, operation); // pass to calc function
        resultText.setText(String.format("%.1f", result)); // arg must be a string
    }

    // This function does the calculation based on the operation specified
    private double calcResult(int num1, int num2, char operation) {
        double result = 0.0;
        switch(operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = (double) num1 / num2;
                break;
        }
        return result;
    }
}