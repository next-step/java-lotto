package lotto.domain.lotto;

import java.util.List;

public class BasicLotto implements Lotto {
    private Numbers numbers;

    public BasicLotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public BasicLotto(List<LottoNumber> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public Numbers getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
