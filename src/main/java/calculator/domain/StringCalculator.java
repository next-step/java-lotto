package calculator.domain;

import java.util.Objects;

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
