package lotto.domain.lotto.number;

import java.util.Objects;
import lotto.util.NumberValidator;

public class Number {

    private final Integer value;

    public Number(String input) {
        this(NumberValidator.validate(input));
    }

    public Number(Integer value) {
        this.value = NumberValidator.validateRange(value);
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
