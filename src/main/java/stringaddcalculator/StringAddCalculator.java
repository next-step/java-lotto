package stringaddcalculator;

import java.util.List;

public class StringAddCalculator {

    public int add(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        return sum(split(text));
    }

    public boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private List<Integer> split(String text) {
        return StringSpliter.of(text).split();
    }

    public int sum(List<Integer> numbers) {
        return Numbers.of(numbers).sum();
    }
}
