package calculator.model;

import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> findNumbers() {
        List<Number> findNumbers = List.of(numbers.get(0), numbers.get(1));
        numbers.remove(0);
        numbers.remove(0);
        return findNumbers;
    }

    public List<Number> addNumber(int number) {
        numbers.add(0, new Number(number));
        return numbers;
    }
}
