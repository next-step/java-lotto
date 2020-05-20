package domain;

import java.util.List;

public class Calculator {
    public static int sum(List<Number> numbers) {
        return numbers.stream().reduce(new Number("0"), Number::add).getValue();
    }
}
