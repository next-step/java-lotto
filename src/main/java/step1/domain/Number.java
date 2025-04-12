package step1.domain;

import java.math.BigDecimal;

public class Number {
    private final BigDecimal value;

    private Number(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static Number of(long number) {
        return new Number(BigDecimal.valueOf(number));
    }

    public static Number of(int number) {
        return new Number(BigDecimal.valueOf(number));
    }

    public static Number of(double number) {
        return new Number(BigDecimal.valueOf(number));
    }

    public static Number of(float number) {
        return new Number(BigDecimal.valueOf(number));
    }

    public static Number of(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("값은 빈 문자열이나 Null이 아니어야 합니다.");
        }
        return new Number(new BigDecimal(number));
    }

    public static Number of(BigDecimal number) {
        return new Number(number);
    }
}
