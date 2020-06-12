package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private final Splitter splitter;

    public Calculator() {
        this.splitter = new Splitter();
    }

    public int sum(String text) {
        List<Number> numbers = parseNumber(splitter.split(text));
        Number sum = sumValues(numbers);
        return sum.valueOf();
    }

    public List<Number> parseNumber(String[] list) {
        return Arrays.stream(list)
                .map(text -> new Number(text))
                .collect(Collectors.toList());
    }

    public Number sumValues(List<Number> numbers) {
        List<Number> list = new ArrayList<>(numbers);
        Number accumulator = list.remove(0);
        for (Number number : list) {
            accumulator = accumulator.sum(number);
        }
        return accumulator;
    }
}
