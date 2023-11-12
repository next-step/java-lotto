package step2.model;

import java.util.List;

public class Lottery {

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lottery of(List<Integer> numbers) {
        return new Lottery(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
