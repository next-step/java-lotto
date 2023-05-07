package calculator.biz.enums;

import calculator.biz.function.*;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorEnum {

    PLUS("+", (a,b) -> a+b),
    MINUS("-", (a,b) -> a-b),
    DIVIDE("/", (a,b) -> a/b),
    MULTIPLY("*", (a,b) -> a*b);

    private String value;
    private BiFunction<Integer, Integer, Integer> operator;

    OperatorEnum(String value, BiFunction<Integer, Integer, Integer> operator) {
        this.value = value;
        this.operator = operator;
    }


    public String getValue() {
        return value;
    }

    public BiFunction<Integer, Integer, Integer> getOperator() {
        return operator;
    }

    public static BiFunction<Integer, Integer, Integer>  findOperator(String value){
        return Arrays.stream(OperatorEnum.values())
                .filter(operator -> operator.getValue().equals(value))
                .findAny()
                .orElseThrow(() -> new NullPointerException("There is no operator"))
                .getOperator();
    }
}
