package step2.domain;

import java.util.List;

public class PickedNumber {

    private final List<Integer> numbers;

    public PickedNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int match(WinningNumbers winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::confirm).count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> get() {
        return this.numbers;
    }
}
