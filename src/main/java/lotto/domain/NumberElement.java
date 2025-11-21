package lotto.domain;

import java.util.Objects;

public class NumberElement {

    private final int value;

    public NumberElement() {
        this(0);
    }

    public NumberElement(int value) {
        validationRange(value);
        this.value = value;
    }

    private void validationRange(int value) {
        if (isRange(value)) {
            throw new IllegalArgumentException("1에서 45 사이의 숫자를 입력해주세요.");
        }
    }

    private static boolean isRange(int value) {
        return 1 > value || value > 45;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NumberElement that = (NumberElement) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
