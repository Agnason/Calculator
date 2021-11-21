package com.example.calculator;

import com.example.calculator.model.Calculator;
import com.example.calculator.model.CalculatorImpl;
import com.example.calculator.model.Operation;
import com.example.calculator.view.CalculatorView;

public class CalculatorPresenter {
    private CalculatorImpl calculator;
    private CalculatorView calculatorView;
    private Integer argOne =0;
    private Integer argTwo = null;
    private Operation previousOperation = null;

    public CalculatorPresenter(CalculatorImpl calculator, CalculatorView calculatorView) {
        this.calculator = calculator;
        this.calculatorView = calculatorView;
    }

    public void onCommaPressed() {


    }

    public void onDigitPressed(int integer) {
        if (previousOperation != null) {
            argTwo = integer;
            calculatorView.showResult(String.valueOf(argTwo));

        } else {
            argOne = integer;

            calculatorView.showResult(String.valueOf(argOne));

        }
    }

    public void onOperandPressed(Operation operation) {
        if (argTwo != null) {
            int result = calculator.performOperation(argOne, argTwo, previousOperation);

            calculatorView.showResult(String.valueOf(result));

            argOne = result;
            argTwo = 0;
        } else {
            argTwo = 0;
            previousOperation = operation;
        }

    }
}

