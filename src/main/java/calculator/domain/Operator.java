package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (preValue, postValue) -> preValue + postValue),
    MINUS("-", (preValue, postValue) -> preValue - postValue),
    MULTIPLY("*", (preValue, postValue) -> preValue * postValue),
    DIVIDE("/", (preValue, postValue) -> preValue / postValue);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    static Operator find(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 문자와 일치하는 연산자를 찾을 수 없습니다."));
    }

    Number calculate(Operand preOperand, Operand postOperand) {
        Number preNumber = preOperand.number();
        Number postNumber = postOperand.number();
        int preValue = preNumber.value();
        int postValue = postNumber.value();
        Integer result = expression.apply(preValue, postValue);
        return new Number(result);
    }
}
