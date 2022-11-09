package lotto.domain;


import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(LottoNumberStrategy numberStrategy) {
        numbers = new ArrayList<>(numberStrategy.getNumbers());
    }

    public long matchCount(Lotto winningLotto) {
        return winningLotto.winningCount(numbers);
    }

    public long winningCount(List<Integer> lottoNumbers) {
        return numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
