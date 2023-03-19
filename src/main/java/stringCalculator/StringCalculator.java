package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text) {

        if (isNull(text) || isEmpty(text)) {
            return 0;
        }

        String[] tokens = split(text);

        return sum(tokens);
    }

    private boolean isNull(String text) {
        return text == null;
    }
    private boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private int sum(String[] values) {
        int[] numbers = toNumbers(values);
        int result = 0;
        for (int number : numbers) {
            checkNumber(number);
            result += number;
        }
        return result;
    }

    private int[] toNumbers(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private void checkNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

}
