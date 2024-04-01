package calculator.enums;

import java.util.function.DoubleBinaryOperator;

public enum OperatorEnum {

    ADD("+", (a, b) -> a + b),
    SUBSTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a,b) -> a * b),
    DIVIDE("/", (a,b) -> {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final String symbol;
    private final DoubleBinaryOperator operator;

    OperatorEnum(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static double calculate(String symbol, double a, int b) {
        switch(symbol) {
            case "+":
                return ADD.operator.applyAsDouble(a, b);
            case "-":
                return SUBSTRACT.operator.applyAsDouble(a, b);
            case "*":
                return MULTIPLY.operator.applyAsDouble(a, b);
            case "/":
                return DIVIDE.operator.applyAsDouble(a, b);
            default:
                throw new IllegalArgumentException("연산자를 잘못 입력했습니다.");
        }
    }

    public static String fromString(String symbol) {
        for (OperatorEnum opEnum : OperatorEnum.values()) {
            if (opEnum.symbol.equals(symbol)) {
                return opEnum.symbol;
            }
        }
        throw new IllegalArgumentException("해당되는 연산자가 없습니다.");
    }
}
