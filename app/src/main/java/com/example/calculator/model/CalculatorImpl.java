package com.example.calculator.model;

public class CalculatorImpl implements Calculator {

    @Override
    public double performOperation(double argOne, double argTwo, Operation operation) {
        switch (operation) {
            case NUM:
                return argOne + argTwo;
            case SUB:
                return argOne - argTwo;
            case MULT:
                return argOne * argTwo;
            case DIV:
                return argOne / argTwo;
            case CLEAN:return argOne;
        }
        return 1;
    }
}
