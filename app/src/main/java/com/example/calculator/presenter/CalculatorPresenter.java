package com.example.calculator.presenter;

import com.example.calculator.model.CalculatorImpl;
import com.example.calculator.view.CalculatorView;

public class CalculatorPresenter {
    private final CalculatorImpl calculatorImpl;
    private final CalculatorView calculatorView;
    private Double operand = null;
    private Double number = 0.0;

    public CalculatorPresenter(CalculatorImpl calculator, CalculatorView calculatorView) {
        this.calculatorImpl = calculator;
        this.calculatorView = calculatorView;
    }

    public void onCommaPressed() {
        number = number / 10;
        calculatorView.showEnterNumberField(String.valueOf(number));
    }

    public void onNumberPressed(int integer) {
        number = number * 10 + integer;
        calculatorView.showEnterNumberField(String.valueOf(number));
    }

    public void onOperationPressed(String operation) {
        if (number != 0.0) {
            Double result = calculatorImpl.performOperation(number, operation);
            calculatorView.showOperation(operation);
            operand = result;
            calculatorView.showResult(String.valueOf(operand));
            number = 0.0;
        } else if (operation == "=") {
            calculatorView.showEnterNumberField(String.valueOf(operand));
        }
    }

    public void onCleanPressed() {
        calculatorView.showEnterNumberField("");
        calculatorView.showOperation("");
        calculatorView.showResult("");
        operand = null;
        number = 0.0;
    }

    public void onZeroZeroPressed() {
        number = number * 100;
        calculatorView.showEnterNumberField(String.valueOf(number));
    }
}

