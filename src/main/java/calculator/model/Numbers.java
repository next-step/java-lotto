package calculator.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Numbers extends Collection<Number> {

    public Numbers() {
        this.values = new ArrayList<>();
    }

    @Override
    public void add(Number number) {
        this.values.add(number);
    }

    @Override
    public void addAll(Collection<Number> numbers) {
        this.values.addAll(numbers.values);
    }

    public Number calculate(Symbols symbols) {
        AtomicInteger index = new AtomicInteger();
        return this.values.stream().reduce((left, right) -> left.calculate(symbols.get(index.getAndIncrement()), right)).orElseThrow();
    }
}
