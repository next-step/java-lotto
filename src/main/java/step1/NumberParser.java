package step1;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    public Numbers parse(Expression expression) {
        List<Integer> numbers = new ArrayList<>();
        final char[] chars = expression.getCharArray();
        for (char ch : chars) {
            addNumbers(numbers, ch);
        }
        return Numbers.of(numbers);
    }

    private void addNumbers(List<Integer> numbers, char ch) {
        if (Character.isDigit(ch)) {
            numbers.add(Integer.parseInt(String.valueOf(ch)));
        }
    }
}
