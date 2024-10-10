package calculator.model;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> findNumbers() {
        List<Integer> findNumbers = List.of(numbers.get(0), numbers.get(1));
        numbers.remove(0);
        numbers.remove(0);
        return findNumbers;
    }

    public List<Integer> addNumber(int number) {
        numbers.add(0, number);
        return numbers;
    }
}
