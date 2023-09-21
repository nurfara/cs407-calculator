package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        // set click listeners for each button
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    openResultActivity('+');
                }
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    openResultActivity('-');
                }
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    openResultActivity('*');
                }
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // check if secondNum is 0 or not
                    int num2 = Integer.parseInt(secondNum.getText().toString());
                    if (num2 != 0) {
                        openResultActivity('/');
                    } else {
                        Toast.makeText(MainActivity.this, "Error: Cannot divide by 0", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    // This function validates user input (Textfield should only accept integers)
    private boolean validateInput() {
        try {
            // try to parse input as int
            Integer.parseInt(firstNum.getText().toString());
            Integer.parseInt(secondNum.getText().toString());
            return true;
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Error: Please enter valid integers", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    // This function opens ResultActivity and passes data
    private void openResultActivity(char operation) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("num1", Integer.parseInt(firstNum.getText().toString()));
        intent.putExtra("num2", Integer.parseInt(secondNum.getText().toString()));
        intent.putExtra("operation", operation);
        startActivity(intent);
    }

}
