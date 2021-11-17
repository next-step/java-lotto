package calculator.domain;

import java.util.Objects;

public class InputValue {
    private String inputStringValue;

    public InputValue(String inputStringValue) {
        this.inputStringValue = inputStringValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputValue that = (InputValue) o;
        return Objects.equals(inputStringValue, that.inputStringValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputStringValue);
    }
}
