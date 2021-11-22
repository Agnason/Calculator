package com.example.calculator;

import com.example.calculator.model.CalculatorImpl;
import com.example.calculator.model.Operation;
import com.example.calculator.view.CalculatorView;

public class CalculatorPresenter {
    private CalculatorImpl calculatorImpl;
    private CalculatorView calculatorView;
    private Double operand = null;
    private Double number = 0.0;
    private Operation operation = null;

    public CalculatorPresenter(CalculatorImpl calculator, CalculatorView calculatorView) {
        this.calculatorImpl = calculator;
        this.calculatorView = calculatorView;
    }

    public void onCommaPressed() {
        calculatorView.showEnterNumberField("");
        calculatorView.showOperation("");
        calculatorView.showResult("");
        operand = null;
        number = null;
        operation = null;
    }

    public void onNumberPressed(int integer) {
        number = number * 10 + integer;
        calculatorView.showEnterNumberField(String.valueOf(number));
    }

    public void onOperationPressed(Operation operation) {
        if (number != 0.0) {
            Double result = calculatorImpl.performOperation(number, operation);
            calculatorView.showOperation(String.valueOf(operation));
            operand = result;
            calculatorView.showResult(String.valueOf(operand));
            number = 0.0;
        } else {

        }
    }
}

