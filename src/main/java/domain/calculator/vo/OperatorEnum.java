package domain.calculator.vo;

import domain.calculator.CalculatorAble;

import java.util.function.BinaryOperator;

public enum OperatorEnum {
    PLUS("+", CalculatorAble::sum),
    MINUS("-", CalculatorAble::subtract),
    MULTIPLY("*", CalculatorAble::multiply),
    DIVIDE("/", CalculatorAble::divide);

    private final String symbol;

    private final BinaryOperator<Integer> calculate;

    OperatorEnum(String symbol, BinaryOperator<Integer> calculate) {
        this.symbol = symbol;
        this.calculate = calculate;
    }

    public static OperatorEnum from(String symbol) {
        for (OperatorEnum operatorEnum : OperatorEnum.values()) {
            if (operatorEnum.symbol.equals(symbol)) {
                return operatorEnum;
            }
        }
        throw new IllegalArgumentException("연산자가 존재하지 않습니다.");
    }

    public int calculate(int leftNumber, int rightNumber) {
        return calculate.apply(leftNumber, rightNumber);
    }
}
