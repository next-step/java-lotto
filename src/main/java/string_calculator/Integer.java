package string_calculator;

import java.util.Objects;

public class Integer implements Value  {
    private final int value;

    public Integer(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Integer{" +
                "value=" + value +
                '}';
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

    public void print(Integer payload) {
        System.out.printf("Result: %d\n", payload.value);
    }
}
