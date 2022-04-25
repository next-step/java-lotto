package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Numbers {

    private final List<Number> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public void add(Number number) {
        this.numbers.add(number);
    }

    public void addAll(Numbers numbers) {
        this.numbers.addAll(numbers.numbers);
    }

    public Number calculate(Symbols symbols) {
        AtomicInteger index = new AtomicInteger();
        return this.numbers
                .stream()
                .reduce((left, right) -> left.calculate(symbols.get(index.getAndIncrement()), right))
                .orElseThrow();
    }
}
