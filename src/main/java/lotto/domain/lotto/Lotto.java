package lotto.domain.lotto;

import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.number.Numbers;

public class Lotto {

    private final Numbers numbers;

    public Lotto(Numbers numbers) {
        this.numbers = new Numbers(numbers);
    }

    public Numbers getLotto() {
        return numbers;
    }

    public boolean hasNumber(Number number) {
        return this.numbers.getNumbers().contains(number);
    }
}
