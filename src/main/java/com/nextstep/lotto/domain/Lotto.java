package com.nextstep.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        if ( numbers == null ) {
            throw new IllegalArgumentException("number is not allow null");
        }

        if ( numbers.size() != LOTTO_NUMBER_COUNT ) {
            throw new IllegalArgumentException("number count shoud be " + LOTTO_NUMBER_COUNT);
        }
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoRank match(WinningLotto winningLotto) {
        long matchedCount = winningLotto.getMatchedCount(numbers);
        boolean matchedBonus = winningLotto.checkBonusNumber(numbers);
        return LottoRank.select(matchedCount, matchedBonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
