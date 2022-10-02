package calculator.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.IntBinaryOperator;

import static java.util.stream.Collectors.toMap;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public enum Operator {
    PLUS("+", (result, num) -> result + num),
    MINUS("-", (result, num) -> result - num),
    MULTIPLE("*", (result, num) -> result * num),
    DIVIDE("/", (result, num) -> {
        if (num == 0 ) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }
        if (result % num != 0) {
            throw new IllegalArgumentException("나누어 떨어지지 않는 수 입니다.");
        }
        return result / num;
    });

    private final String code;
    private final IntBinaryOperator operate;

    private static final Map<String, Operator> operatorCache;

    static {
        operatorCache = Arrays.stream(values())
                .collect(toMap(value -> value.code, value -> value));
    }

    Operator(String code, IntBinaryOperator operator) {
        this.code = code;
        this.operate = operator;
    }

    public int operate(int result, int number) {
        return operate.applyAsInt(result, number);
    }

    public static Operator from(String code) {
        Operator operator = operatorCache.get(code);
        if (operator == null) {
            throw  new IllegalArgumentException("잘못된 연산자 입니다");
        }
        return operator;
    }

    public static boolean isOperator(String code) {
        return operatorCache.containsKey(code);
    }
}
