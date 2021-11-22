package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.model.CalculatorImpl;
import com.example.calculator.presenter.CalculatorPresenter;
import com.example.calculator.view.CalculatorView;

import java.util.HashMap;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {
    // поле ввод значений
    private EditText txtNumberField;
    //    поле операции
    private TextView txtOperation;
    // поле вывода результата
    private TextView txtResult;
    // Presenter
    private CalculatorPresenter calculatorPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        txtNumberField = findViewById(R.id.numberField);
        txtOperation = findViewById(R.id.infoOperation);
        txtResult = findViewById(R.id.result);

        calculatorPresenter = new CalculatorPresenter(new CalculatorImpl(), this);

        findViewById(R.id.button_comma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.onCommaPressed();
            }
        });

        findViewById(R.id.button_C).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorPresenter.onCleanPressed();
            }
        });
        findViewById(R.id.button_00).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorPresenter.onZeroZeroPressed();
            }
        });

        HashMap<Integer, Integer> numbers = new HashMap<>();
        numbers.put(R.id.button_0, 0);
        numbers.put(R.id.button_1, 1);
        numbers.put(R.id.button_2, 2);
        numbers.put(R.id.button_3, 3);
        numbers.put(R.id.button_4, 4);
        numbers.put(R.id.button_5, 5);
        numbers.put(R.id.button_6, 6);
        numbers.put(R.id.button_7, 7);
        numbers.put(R.id.button_8, 8);
        numbers.put(R.id.button_9, 9);


        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.onNumberPressed(numbers.get(view.getId()));
            }
        };
        findViewById(R.id.button_0).setOnClickListener(numberClickListener);
        findViewById(R.id.button_1).setOnClickListener(numberClickListener);
        findViewById(R.id.button_2).setOnClickListener(numberClickListener);
        findViewById(R.id.button_3).setOnClickListener(numberClickListener);
        findViewById(R.id.button_4).setOnClickListener(numberClickListener);
        findViewById(R.id.button_5).setOnClickListener(numberClickListener);
        findViewById(R.id.button_6).setOnClickListener(numberClickListener);
        findViewById(R.id.button_7).setOnClickListener(numberClickListener);
        findViewById(R.id.button_8).setOnClickListener(numberClickListener);
        findViewById(R.id.button_9).setOnClickListener(numberClickListener);


        HashMap<Integer, String> operation = new HashMap<>();
        operation.put(R.id.button_divide, "/");
        operation.put(R.id.button_plus, "+");
        operation.put(R.id.button_minus, "-");
        operation.put(R.id.button_multiply, "*");
        operation.put(R.id.button_equal, "=");
        operation.put(R.id.button_percent, "%");

        View.OnClickListener operationsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.onOperationPressed(operation.get(view.getId()));
            }
        };

        findViewById(R.id.button_divide).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_plus).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_minus).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_multiply).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_C).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_equal).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_percent).setOnClickListener(operationsClickListener);
    }

    @Override
    public void showResult(String value) {
        txtResult.setText(value);
    }

    @Override
    public void showOperation(String operation) {
        txtOperation.setText(operation);
    }


    @Override
    public void showEnterNumberField(String number) {
        txtNumberField.setText(number);
    }

}
