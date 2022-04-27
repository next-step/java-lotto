package step1;

import java.util.Objects;

public class Input {

    private static final String DELIMITER = " ";

    private final String value;

    public Input(String input) {
        validate(input);
        this.value = input;
    }

    private void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("널이거나 공백 입력입니다.");
        }
    }

    public String[] split() {
        return this.value.split(DELIMITER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input = (Input) o;
        return Objects.equals(value, input.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
