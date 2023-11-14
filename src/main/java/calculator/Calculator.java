package calculator;

public class Calculator {

    private final String input;

    public Calculator(String input) {
        this.input = input;
    }

    public void validateInput() {
        boolean isNull = this.input == null;
        if (isNull) {
            throw new IllegalArgumentException("input is null.");
        }
        boolean isEmpty = this.input.isEmpty();
        if (isEmpty) {
            throw new IllegalArgumentException("input is empty string.");
        }
    }
}
