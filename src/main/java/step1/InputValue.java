package step1;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-16.
 */
public class InputValue {

    private final String input;
    private static final String ZERO = "0";

    private InputValue(String input) {
        this.input = input;
    }

    public static InputValue of(String input) {
        input = checkInput(input);

        return new InputValue(input);
    }

    public String getInput() {
        return input;
    }

    private static String checkInput(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return ZERO;
        }
        return input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputValue that = (InputValue) o;
        return Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
