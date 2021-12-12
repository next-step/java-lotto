package calculator;

import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Number sum() {
        return numbers.stream().reduce(Number.ZERO_NUMBER, Number::add);
    }

}
