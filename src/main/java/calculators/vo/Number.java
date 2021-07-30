package calculators.vo;

import java.util.Objects;

public class Number {

    private final int value;

    private Number(String input) {
        try {
            this.value = Integer.parseInt(input);
            if (value < 0) {
                throw new RuntimeException("음수는 사용할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만 사용 가능합니다.");
        }
    }

    public static Number from(String input) {
        return new Number(input);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
