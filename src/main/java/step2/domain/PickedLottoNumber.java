package step2.domain;

import java.util.Collections;
import java.util.List;

public class PickedLottoNumber {

    private final List<Integer> numbers;

    public PickedLottoNumber(List<Integer> numbers) {
        Collections.sort(numbers);
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
