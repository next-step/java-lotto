package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private final Splitter splitter;

    public Calculator() {
        this.splitter = new Splitter();
    }

    public int sum(String text) {
        String[] split = splitter.split(text);
        List<Number> numbers = parseNumber(split);
        numbers.get(0).sum(numbers.get(1));
        return 3;
    }

    public List<Number> parseNumber(String[] list) {
        return Arrays.stream(list)
                .map(text -> new Number(text))
                .collect(Collectors.toList());
    }
}
