package calculator.domain;

public class InputNumber {

    private final String input;

    public InputNumber(String input) {
        this.input = input;
    }

    public boolean isEmpty() {
        return input == null || input.trim().isEmpty();
    }

    public int getNumbers() {
        return Integer.parseInt(input);
    }
}
