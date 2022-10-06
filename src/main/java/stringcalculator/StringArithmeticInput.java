package stringcalculator;

public class StringArithmeticInput {
    private static final String DELIMITER = " ";

    private final String input;
    public StringArithmeticInput(String input) {
        if (input == null || input.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("공백은 불가능합니다");
        }

        this.input = input;
    }

    public Number evaluate() {
        String[] expression = input.split(DELIMITER);

        return Number.of(1);
    }

}
