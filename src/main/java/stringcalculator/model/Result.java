package stringcalculator.model;

import java.util.Objects;

public class Result {
    private final int value;

    public Result(final Integer number) {
        this.value = number;
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return value == result.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
