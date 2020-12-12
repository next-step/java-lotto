package com.nextstep.lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if ( numbers.size() != LOTTO_NUMBER_COUNT ) {
            throw new IllegalArgumentException("number count shoud be " + LOTTO_NUMBER_COUNT);
        }
        this.numbers = numbers;
    }

    public LottoWinning getWinning(List<Integer> winningNumbers) {
        return LottoWinning.select(winningNumbers, numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
