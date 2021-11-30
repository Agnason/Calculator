package com.example.calculator.model;

public class CalculatorImpl implements Calculator {

    Double operand = 0.0;

    @Override
    public Double performOperation(Double number, String string) {

        switch (string) {
            case "+": {
                return operand += number;
            }
            case "-": {
                return operand -= number;
            }
            case "*": {
                return operand *= number;
            }
            case "/": {
                if (number == 0) {
                    operand = 0.0;
                } else return operand /= number;
            }
            case "%": {
                return operand = number / 100;
            }
        }
        return number;
    }
}
