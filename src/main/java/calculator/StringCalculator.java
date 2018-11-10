package calculator;

import calculator.parser.Parsable;

public class StringCalculator {
    public static int add(Parsable parsable) {
        String[] numbers = parsable.getSplitResult();

        if (numbers == null) {
            return 0;
        }

        return getSum(numbers);
    }

    private static int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
