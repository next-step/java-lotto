package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {
    private static final String DELIMITER = ",";

    public int add(String text) {
        // validateText(text);
        String[] numbers = splitText(text);
        return sumNumbers(numbers);
    }

    public int validateText(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(text);
    }

    public String[] splitText(String text) {
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
