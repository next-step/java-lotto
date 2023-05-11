package lotto.domain;

import java.util.List;

public class WinLotto {
    private final Numbers numbers;
    private final Integer bonusNumber;

    public WinLotto(Numbers numbers) {
        this(numbers, null);
    }

    public WinLotto(Numbers numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public WinLotto(List<Integer> numbers, Integer bonusNumber) {
        this(new Numbers(numbers), bonusNumber);
    }

    public Numbers numbers() {
        return numbers;
    }

    public Integer findNumber(int i) {
        return numbers.find(i);
    }

    public Integer bonusNumber() {
        return bonusNumber;
    }
}
