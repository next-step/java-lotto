package calculator;

public class Calculator {
    public static final String DELIMITER = ",|:";

    private final Numbers numbers;

    public Calculator(String input) {
        if (input.contains(",") || input.contains(":")) {
            String[] splitInput = input.split(DELIMITER);
            numbers = new Numbers(splitInput);
        } else {
            numbers = new Numbers(Integer.parseInt(input));
        }
    }

    public int sum() {
        return numbers.sum();
    }
}
