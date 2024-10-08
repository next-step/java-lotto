package calculator.domain;

import java.util.Arrays;
import java.util.Objects;

public class Strings {
    public static final int FIRST_INDEX = 0;
    private final String[] values;

    public Strings(final String[] values) {
        this.values = values;
    }

    public String getFirst() {
        return this.values[FIRST_INDEX];
    }

    public int length() {
        return this.values.length;
    }

    public String get(final int index) {
        return this.values[index];
    }

    public String getNext(final int index) {
        return this.values[index + 1];
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Strings strings = (Strings) o;
        return Objects.deepEquals(values, strings.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
