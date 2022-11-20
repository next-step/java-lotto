package calculator.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS((num1, num2) -> num1 + num2),
    MINUS((num1, num2) -> num1 - num2),
    MULTIPLY((num1, num2) -> num1 * num2),
    DIVIDE((num1, num2) -> num1 / num2);

    private final IntBinaryOperator calFunction;


    Operator(IntBinaryOperator calFunction) {
        this.calFunction = calFunction;
    }

    public int calculateFunction(int a, int b) {
        return calFunction.applyAsInt(a, b);
    }
}