package calculator.model;

import java.util.List;

public class Calculator {
    InputNumber number;
    Operator operator;

    public Calculator(InputNumber number, Operator operator) {
        this.number = number;
        this.operator = operator;
    }

    public int calculate() {
        return 0;
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int multiplication(int a, int b) {
        return a * b;
    }

    private int division(int a, int b) {
        return a / b;
    }
}
