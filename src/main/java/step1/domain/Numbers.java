package step1.domain;

import step1.NegativeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {

    private List<Number> numbers;

    public Numbers(String text) {
        this.numbers = createNumbers(text);
    }

    private List<Number> createNumbers(String text) {
        if(checkZero(text)) {
            return zero(text);
        }
        return Arrays.stream(stringToArray(text))
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private List<Number> zero(String text) {
        List<Number> zero = new ArrayList<>();
        zero.add(new Number(0));

        return zero;
    }

    private boolean checkZero(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }

        return false;
    }

    private String[] stringToArray(String inputText) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return inputText.split(",|:");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public int sum() {
        int sum = numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();

        return sum;
    }
}
