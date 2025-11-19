package calculator.model;

import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Number nextNumber(int index) {
        return numbers.get(index);
    }

    public Number initResult() {
        return numbers.getFirst();
    }
}
