package Calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalculator {

    private final Pattern USER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int add(String text) {
        if (text == null || text.isEmpty()) return 0;
        return sum(getNumbers(text));
    }

    private String[] getNumbers(String text) {
        Matcher m = USER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        } else {
            return text.split(",|:");
        }
    }

    private int sum(String[] numbers) {
        int sumNumber = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (Integer.parseInt(numbers[i]) < 0) {
                throw new RuntimeException();
            }
            sumNumber += Integer.parseInt(numbers[i]);
        }
        return sumNumber;
    }

}
