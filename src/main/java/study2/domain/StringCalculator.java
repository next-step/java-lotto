package study2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final List<Integer> numbers;

    public StringCalculator(String input) {
        String[] stringNumbers = splitInput(parseEmptyToZero(input));
        numbers = parsePositiveNumbers(stringNumbers);
    }

    private String parseEmptyToZero(String stringNumber) {
        if (stringNumber == null || stringNumber.trim().isEmpty()) {
            return "0";
        }
        return stringNumber;
    }

    private String[] splitInput(String input) {
        String separator = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            separator = m.group(1);
            return m.group(2).split(separator);
        }
        return input.split(separator);
    }

    private List<Integer> parsePositiveNumbers(String[] stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(parsePositiveNumber(stringNumber));
        }
        return numbers;
    }

    private Integer parsePositiveNumber(String stringNumber) {
        Integer number = Integer.parseInt(stringNumber);
        validate(number);
        return number;
    }

    private void validate(Integer number) {
        if (number < 0) {
            throw new RuntimeException("음수가 존재합니다.");
        }
    }

    public int sum() {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
