package lotto.domain.lotto;

import lotto.domain.wrapper.Numbers;

public class Lotto {

    private Numbers numbers;

    public Lotto() {
    }

    public Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public int countMatchingNumbers(Numbers winningNumbers) {
        return this.numbers.countMatchingNumbers(winningNumbers);
    }
}
