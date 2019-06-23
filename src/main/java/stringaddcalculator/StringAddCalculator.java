package stringaddcalculator;

import java.util.List;

public class StringAddCalculator {

    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return Numbers.of(split(text)).sum();
    }

    private List<Integer> split(String text) {
        return StringSpliter.of(text).split();
    }
}
