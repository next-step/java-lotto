package calculator;


public class StringAddCalculator {

    public int plus(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = input.split(",");
        return getSum(numbers);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.replaceAll(" ", "").isEmpty();
    }

    private int getSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
