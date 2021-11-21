package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.model.CalculatorImpl;
import com.example.calculator.model.Operation;
import com.example.calculator.view.CalculatorView;

import java.util.HashMap;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {
    private TextView txtResult;
    private CalculatorPresenter calculatorPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        txtResult = findViewById(R.id.result);
        calculatorPresenter = new CalculatorPresenter(new CalculatorImpl(), this);

        findViewById(R.id.button_comma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.onCommaPressed();
            }
        });

        HashMap<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.button_0, 0);
        digits.put(R.id.button_00, 00);
        digits.put(R.id.button_1, 1);
        digits.put(R.id.button_2, 2);
        digits.put(R.id.button_3, 3);
        digits.put(R.id.button_4, 4);
        digits.put(R.id.button_5, 5);
        digits.put(R.id.button_6, 6);
        digits.put(R.id.button_7, 7);
        digits.put(R.id.button_8, 8);
        digits.put(R.id.button_9, 9);


        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.onDigitPressed(digits.get(view.getId()));
            }
        };
        findViewById(R.id.button_0).setOnClickListener(digitClickListener);
        findViewById(R.id.button_00).setOnClickListener(digitClickListener);
        findViewById(R.id.button_1).setOnClickListener(digitClickListener);
        findViewById(R.id.button_2).setOnClickListener(digitClickListener);
        findViewById(R.id.button_3).setOnClickListener(digitClickListener);
        findViewById(R.id.button_4).setOnClickListener(digitClickListener);
        findViewById(R.id.button_5).setOnClickListener(digitClickListener);
        findViewById(R.id.button_6).setOnClickListener(digitClickListener);
        findViewById(R.id.button_7).setOnClickListener(digitClickListener);
        findViewById(R.id.button_8).setOnClickListener(digitClickListener);
        findViewById(R.id.button_9).setOnClickListener(digitClickListener);


        HashMap<Integer, Operation> operands = new HashMap<>();
        operands.put(R.id.button_divide, Operation.DIV);
        operands.put(R.id.button_plus, Operation.NUM);
        operands.put(R.id.button_minus, Operation.SUB);
        operands.put(R.id.button_multiply, Operation.MULT);
        operands.put(R.id.button_C, Operation.CLEAN);

        View.OnClickListener operandsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.onOperandPressed(operands.get(view.getId()));
            }
        };

        findViewById(R.id.button_divide).setOnClickListener(operandsClickListener);
        findViewById(R.id.button_plus).setOnClickListener(operandsClickListener);
        findViewById(R.id.button_minus).setOnClickListener(operandsClickListener);
        findViewById(R.id.button_multiply).setOnClickListener(operandsClickListener);
        findViewById(R.id.button_C).setOnClickListener(operandsClickListener);

    }


    @Override
    public void showResult(String value) {
        txtResult.setText(value);

    }
}
