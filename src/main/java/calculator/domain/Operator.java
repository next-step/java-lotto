package calculator.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

import static java.util.stream.Collectors.toMap;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public enum Operator {
    PLUS("+", (result, inputValue) -> result.plus(inputValue)),
    MINUS("-", (result, inputValue) -> result.minus(inputValue)),
    MULTIPLE("*", (result, inputValue) -> result.multiple(inputValue)),
    DIVIDE("/", (result, inputValue) -> result.divide(inputValue));

    private final String code;
    private final BiFunction<CalculateResult, InputValue, CalculateResult> operate;

    private static final Map<String, Operator> operatorCache;

    static {
        operatorCache = Arrays.stream(values())
                .collect(toMap(value -> value.code, value -> value));
    }

    Operator(String code, BiFunction<CalculateResult, InputValue, CalculateResult> operate) {
        this.code = code;
        this.operate = operate;
    }

    public static Operator from(String code) {
        Operator operator = operatorCache.get(code);
        if (operator == null) {
            throw  new IllegalArgumentException("잘못된 연산자 입니다");
        }
        return operator;
    }

    @Deprecated
    public static Operator from(InputValue value) {
        if (!value.isOperator()) {
            throw  new IllegalArgumentException("연산자가 아닙니다.");
        }

        Operator operator = operatorCache.get(value);
        if (operator == null) {
            throw  new IllegalArgumentException("잘못된 연산자 입니다");
        }

        return operator;
    }

    public static boolean isOperator(String code) {
        return operatorCache.containsKey(code);
    }

    public CalculateResult operate(CalculateResult calculateResult, InputValue inputValue) {
        return operate.apply(calculateResult, inputValue);
    }
}
