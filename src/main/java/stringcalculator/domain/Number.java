package stringcalculator.domain;

import java.util.Objects;

public class Number {

    private final Double number;

    Number(Double number) {
        if (number == null) {
            throw new IllegalArgumentException("null로는 Operand를 생성할 수 없습니다.");
        }
        this.number = number;
    }

    public Double value() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Number number1 = (Number) o;

        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
