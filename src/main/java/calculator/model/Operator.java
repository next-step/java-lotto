package calculator.model;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (a, b)-> a+b),
    MINUS("-", (a, b)-> a-b),
    MULTIPLY("*", (a, b)-> a*b),
    DIVISION("/", (a, b)-> {
        if(b.equals(0)) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a/b;
    });

    private final String operator;
    private final BinaryOperator<Integer> calculate;

    Operator(String operator, BinaryOperator<Integer> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public Integer calculate(Integer a, Integer b){
        return calculate.apply(a, b);
    }

    public static Operator of(String string){
        return Arrays.stream(Operator.values())
                .filter(op -> op.isEqual(string))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException(string + " 잘못된 연산자입니다."));
    }

    private boolean isEqual(String operator){
        return operator.equals(this.operator);
    }
}
