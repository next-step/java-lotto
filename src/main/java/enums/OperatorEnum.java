package enums;

import domain.Symbols;

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


    public static DoubleBinaryOperator fromSymbol(String symbol) {
        switch(symbol) {
            case "+":
                return ADD.operator;
            case "-":
                return SUBSTRACT.operator;
            case "*":
                return MULTIPLY.operator;
            case "/":
                return DIVIDE.operator;
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
