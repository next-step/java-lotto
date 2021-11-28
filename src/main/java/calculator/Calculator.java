package calculator;

public class Calculator {
    public static final String DELIMITER = ",|:";

    private final Numbers numbers;

    public Calculator(String input) {
        if (input.contains(",") || input.contains(":")) {
            String[] splitInput = input.split(DELIMITER);
            numbers = new Numbers(splitInput);
        } else if (input.contains("//") && input.contains("\n")) {
            char delimiter = input.charAt(2);
            String substring = input.substring(4);
            String[] splitInput = substring.split(String.valueOf(delimiter));
            numbers = new Numbers(splitInput);
        } else {
            numbers = new Numbers(Integer.parseInt(input));
        }
    }

    public int sum() {
        return numbers.sum();
    }
}
