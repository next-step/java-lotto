package calculator;

public class Calculator {

    private final int result;

    public Calculator(String input) {
        String line = checkNumber(input);

        String[] numbers = line.split(",|:");
        int sum = sum(numbers);

        this.result = sum;
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }

    private String checkNumber(String input) {
        if (input == null) {
            return "0";
        }
        if (input.isEmpty()) {
            return "0";
        }
        return input;
    }

    public int getResult() {
        return result;
    }
}
