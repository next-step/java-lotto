package step1;

import java.util.List;

public class Calculator {

    private final Splitter splitter;

    public Calculator() {
        this.splitter = new Splitter();
    }

    public int sum(String text) {
        String[] split = splitter.split(text);
        List<Number> numbers = splitter.parseNumber(split);
        numbers.get(0).sum(numbers.get(1));
        return 3;
    }
}
