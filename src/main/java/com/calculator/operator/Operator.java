package com.calculator.operator;

public interface Operator {
    int operate(int firstNumber, int secondNumber);

    static Operator getOperator(String operator) {
        switch (operator) {
            case Add.OPERATION_SYMBOL:
                return new Add();
            case Withdraw.OPERATION_SYMBOL:
                return new Withdraw();
            case Multiply.OPERATION_SYMBOL:
                return new Multiply();
            case Division.OPERATION_SYMBOL:
                return new Division();
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다!");
    }
}
