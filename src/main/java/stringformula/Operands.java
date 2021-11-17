package stringformula;

import java.util.List;

public class Operands {

    private final List<Number> numbers;

    public Operands(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Number sumAll() {
        return numbers.stream()
                .reduce(new Number(0), Number::plus);
    }
}
