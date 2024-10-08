package calculator.domain;

import java.util.Objects;

public class Input {
    public static final String DELIMITER = "\\s+";

    private final String value;

    public Input(final String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Cannot be blank");
        }
        this.value = value.trim();
    }

    public Strings split() {
        return new Strings(this.value.split(DELIMITER));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Input that = (Input) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "InputString{" +
                "value='" + value + '\'' +
                '}';
    }
}
