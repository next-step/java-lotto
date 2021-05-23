package lotto.lotto;

import java.util.Set;

public class Answer {
    Set<LottoNumber> numbers;

    public Answer(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public Set<LottoNumber> numbers() {
        return numbers;
    }
}
