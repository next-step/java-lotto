package step1.domain;

import java.util.List;

public class Calculator {

    public Number Add(List<Integer> input) {
        return new Number(input.stream().reduce(0, Integer::sum));
    }
}
