package calculator.domain;

import java.util.Objects;

public class NumberElement implements Element {
    int value;

    NumberElement(String value) {
        this(Integer.parseInt(value));
    }

    NumberElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NumberElement element = (NumberElement) obj;
        return this.value == element.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
