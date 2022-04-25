package calculator.model.collection;

import calculator.model.Number;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Numbers extends Collection<Number> {

    public Numbers() {
        this.values = new ArrayList<>();
    }

    public Number calculate(Symbols symbols) {
        AtomicInteger index = new AtomicInteger();
        return this.values.stream().reduce((left, right) -> left.calculate(symbols.get(index.getAndIncrement()), right)).orElseThrow();
    }
}
