package lotto.domain.lotto;

import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.number.Numbers;

public class Lotto {

    private final Numbers numbers;

    public Lotto(Numbers numbers) {
        this.numbers = new Numbers(numbers);
    }

    public boolean hasNumber(Number number) {
        return this.numbers.has(number);
    }

    public Integer getMatchCount(Lotto lotto) {
        return this.numbers.getMatchCount(lotto);
    }

    public Numbers getLotto() {
        return new Numbers(numbers);
    }

}
