package kr.insup.calculator;

public class StringAddCalculator {
    public int calculate(String input) {
        String[] numbers = input.split("[:,]");
        return calculateNumbers(numbers);
    }

    private int calculateNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += stringToIntConverter(number);
        }
        return sum;
    }

    private int stringToIntConverter(String number) {
        if (number == null || number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }
}
