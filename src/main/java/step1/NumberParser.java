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
        return numbers;
    }

    private void addNumbers(List<Integer> numbers, char ch) {
        if (Character.isDigit(ch)) {
            numbers.add(Integer.parseInt(String.valueOf(ch)));
        }
    }
}
