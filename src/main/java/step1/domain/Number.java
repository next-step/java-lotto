package step1.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 숫자 표현을 위한 VO
 */
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Number number = (Number)o;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
