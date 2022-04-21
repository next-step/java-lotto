package string_calculator;

import java.util.Objects;

public class Integer implements Value{
    private final int value;

    public Integer(int i) {
        this.value = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integer integer = (Integer) o;
        return value == integer.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
