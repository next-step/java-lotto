package com.calculator.operator;

public class Withdraw implements Operator {
    public static final String OPERATION_SYMBOL = "-";

    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
