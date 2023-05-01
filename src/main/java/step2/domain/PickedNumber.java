package step2.domain;

import java.util.List;

public class PickedNumber {

    private final List<Integer> numbers;

    public PickedNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> get() {
        return this.numbers;
    }
}
