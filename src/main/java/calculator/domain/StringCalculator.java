package calculator.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DELIMITER = ",|:";

    public int add(String text) {
        try {
            validateText(text);
        } catch (IllegalArgumentException e) {
            return 0;
        }
        String[] numbers = splitText(text);
        return sumNumbers(numbers);
    }

    public void validateText(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public String[] splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter + '|' + DELIMITER);
            return tokens;
        }
        return text.split(DELIMITER);
    }

    public int sumNumbers(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
