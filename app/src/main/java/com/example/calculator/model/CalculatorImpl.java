package com.example.calculator.model;

public class CalculatorImpl implements Calculator {

    Double operand = 0.0;
    @Override
    public Double performOperation(Double number, Operation operation) {


        switch (operation) {
            case NUM:
                return operand += number;
            case SUB:
                return operand -= number;
            case MULT:
                return operand *=number;
            case DIV:
                if (number==0){
                    operand=0.0;
                }else return operand /=number;
            case EQUAL:
                return operand=number;
            case CLEAN:
                return operand=number;
        }
        return number;
    }
}
