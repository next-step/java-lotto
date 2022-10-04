package com.calculator.operator;

public enum Operator {

    ADD("+", (firstNumber, secondNumber) -> firstNumber + secondNumber), // Integer::sum 도 가능
    WITHDRAW("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVISION("/", (firstNumber, secondNumber) -> {
        isValidNumberForDivision(firstNumber, secondNumber);
        return firstNumber / secondNumber;
    });

    private static void isValidNumberForDivision(Integer firstNumber, Integer secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("올바른 나눗셈 인자가 아닙니다! (0으로 나눌 수 없습니다!)");
        }
        if (firstNumber % secondNumber > 0) {
            throw new IllegalArgumentException("올바른 나눗셈 인자가 아닙니다! (나눗셈의 결과 값이 정수가 아닙니다!)");
        }
    }

    private final String symbol;
    private final FunctionWithTwoArgs<Integer, Integer, Integer> expression;

    Operator(String symbol, FunctionWithTwoArgs<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Operator getOperator(String symbol) {
        if (symbol.equals(ADD.symbol)) return ADD;
        if (symbol.equals(WITHDRAW.symbol)) return WITHDRAW;
        if (symbol.equals(MULTIPLY.symbol)) return MULTIPLY;
        if (symbol.equals(DIVISION.symbol)) return DIVISION;
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다!");
    }

    public static int calculateValue(String symbol, int firstNum, int secondNum) {
        return getOperator(symbol).expression.apply(firstNum, secondNum);
    }
}
