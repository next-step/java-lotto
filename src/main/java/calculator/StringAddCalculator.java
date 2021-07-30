package calculator;

public class StringAddCalculator {

    public int calculate(String input) {
        if (input.isEmpty() || input == null) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] numbers = getNumbers(input);

        int result = sum(numbers);

        return result;
    }

    private Integer sum(String[] numbers) {
        Integer result;
        result = Integer.parseInt(numbers[0])+ Integer.parseInt(numbers[1]);
        return result;
    }

    private String[] getNumbers(String input) {
        return input.split(",");
    }
}
