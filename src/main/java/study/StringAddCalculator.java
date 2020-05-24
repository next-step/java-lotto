package study;

import java.util.Collections;
import java.util.List;

public class StringAddCalculator {

    private final StringSplitter splitter;

    public StringAddCalculator(StringSplitter splitter) {
        this.splitter = splitter;
    }

    public int splitAndSum(String text) {
        List<Integer> numbers = split(text);
        checkNegative(numbers);
        return sum(numbers);
    }

    private List<Integer> split(String text) {
        if (StringUtil.isNullOrEmpty(text)) {
            return Collections.singletonList(0);
        }

        String[] tokens = splitter.split(text);
        return IntegerUtil.parseArray(tokens);
    }

    private Integer sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private void checkNegative(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n < 0)
                .findAny()
                .ifPresent(t -> {throw new RuntimeException();});
    }
}
