package calculator;

import calculator.objects.Number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            delimiter = m.group(1);
            String[] numbers = m.group(2).split(delimiter);

            return getSum(numbers);
        }

        String[] numbers = input.split(delimiter);

        return getSum(numbers);
    }

    public int getSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            if (Number.isNegative(number)) {
                throw new RuntimeException();
            }

            sum += Integer.parseInt(number);
        }

        return sum;
    }

}
