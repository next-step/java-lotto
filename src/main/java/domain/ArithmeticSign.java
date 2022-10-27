package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum ArithmeticSign {
    PLUS("+", (num1, num2) -> new Number(num1.getNumber() + num2.getNumber())),
    MINUS("-", (num1, num2) -> new Number(num1.getNumber() - num2.getNumber())),
    MULTIPLICATION("*", (num1, num2) -> new Number(num1.getNumber() * num2.getNumber())),
    DIVISION("/", (num1, num2) -> {
        if (num2.getNumber() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        if (num1.getNumber() * 1.0 / num2.getNumber() % 1 != 0) {
            throw new IllegalArgumentException("결과값이 정수가 아닙니다.");
        }
        return new Number(num1.getNumber() / num2.getNumber());
    }
    );

    private final String sign;
    private BiFunction<Number, Number, Number> expression;

    ArithmeticSign(String sign, BiFunction<Number, Number, Number> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public static ArithmeticSign of(String sign) {
        return Arrays.stream(values())
                .filter(v -> sign.equals(v.sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산에 해당하지 않는 기호식입니다."));
    }

    public Number doArithmetic(Number num1, Number num2) {
        return expression.apply(num1, num2);
    }

}
