package lotto.domain;

import java.util.List;

public class Lotto {
    List<Integer> numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers.generateRandomNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }
}
