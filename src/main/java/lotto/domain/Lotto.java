package lotto.domain;


import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(LottoNumberStrategy numberStrategy) {
        numbers = new ArrayList<>(numberStrategy.getNumbers());
    }

    public long matchCnt(Lotto winningLotto) {
        return winningLotto.winningCnt(numbers);
    }

    public long winningCnt(List<Integer> lottoNumbers) {
        return numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
