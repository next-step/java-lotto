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
        return this.numbers.getNumbersValue().contains(number);
    }

    public Integer getMatchCount(Lotto lotto) {
        return Math.toIntExact(this.numbers.getNumbersValue().stream().filter(lotto::hasNumber).count());
    }
}
