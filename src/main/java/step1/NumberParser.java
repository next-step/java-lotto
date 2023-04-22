package step1;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    public List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<>();
        final char[] chars = input.toCharArray();
        for (char ch : chars) {
            addNumbers(numbers, ch);
        }

        validate(numbers);
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자가 없습니다.");
        }
    }

    private void addNumbers(List<Integer> numbers, char ch) {
        if (Character.isDigit(ch)) {
            numbers.add(Integer.parseInt(String.valueOf(ch)));
        }
    }
}
