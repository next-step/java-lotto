package calculator.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-05
 */
public enum Operator {

    PLUS("+", (result, input) -> result + input),
    MINUS("-", (result, input) -> result - input),
    MULTIPLE("*", (result, input) -> result * input),
    DIVIDE("/", (result, input) -> {
        validateDivide(result, input);
        return result / input;
    });

    private static final Map<String, Operator> OPERATOR_CACHE;

    private final String code;
    private final IntBinaryOperator calculatorOperate;

    Operator(String code, IntBinaryOperator operator) {
        this.code = code;
        this.calculatorOperate = operator;
    }

    static {
        OPERATOR_CACHE = Arrays.stream(values())
                .collect(Collectors.toMap(value -> value.code, value -> value));
    }

    public static boolean isOperator(String code) {
        return OPERATOR_CACHE.containsKey(code);
    }

    public static Operator from(String code) {
        Operator operator = OPERATOR_CACHE.get(code);

        if (operator == null) {
            throw new IllegalArgumentException("잘못된 연산자 입니다.");
        }

        return operator;
    }

    public int operate(int result, int input) {
        return calculatorOperate.applyAsInt(result, input);
    }

    private static void validateDivide(int result, int input) {
        if (input == 0) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다");
        }

        if (isNotDividable(result, input)) {
            throw new IllegalArgumentException("나누어 떨어지지 않는 수 입니다.");
        }
    }

    private static boolean isNotDividable(int result, int input) {
        return result % input != 0;
    }
}
