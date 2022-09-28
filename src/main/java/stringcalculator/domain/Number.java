package stringcalculator.domain;

import java.util.Objects;

public class Number {
    private final int value;

    public Number(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백문자 입니다.");
        }

        this.value = Integer.parseInt(input);

    }

    public int getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return this.value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}
