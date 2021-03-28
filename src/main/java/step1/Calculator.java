package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private final Splitter splitter;

    public Calculator(Splitter splitter) {
        this.splitter = splitter;
    }

    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        List<Number> numbers = parseNumber(splitter.split(text));
        return sumValues(numbers);
    }

    public List<Number> parseNumber(String[] list) {
        return Arrays.stream(list)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public int sumValues(List<Number> numbers) {
        int sum = 0;
        for (Number number : numbers) {
            sum += number.valueOf();
        }
        return sum;
    }
}
