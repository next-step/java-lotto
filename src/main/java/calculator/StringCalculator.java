package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER = ",|:";

    public int add(String text) {
        if (checkNotValidInput(text)) {
            return 0;
        }

        String[] numbersSplit = splitText(text);
        checkPositiveNumber(numbersSplit);

        int[] numbers = StringToIntConverter(numbersSplit);

        return sum(numbers);
    }

    public void checkPositiveNumber (String[] numbers) {
        for (String number : numbers) {
            checkNotIntegerNumber(number);
            checkNotNegativeNumber(number);
        }
    }

    private void checkNotIntegerNumber(String number) {
        if (number == null || number.length() == 0 || !number.chars().allMatch(Character::isDigit)) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private void checkNotNegativeNumber(String number) {
        if (Integer.parseInt(number) < 0)  {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private int[] StringToIntConverter(String[] numbers) {
        return Stream.of(numbers).mapToInt(Integer::parseInt).toArray();
    }

    private String[] splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        return text.split(",|:");
    }

    private Boolean checkNotValidInput(String text) {
        if (text == null || "".equals(text)) {
            return true;
        }
        return false;
    }

    private int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
