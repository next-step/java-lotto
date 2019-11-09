package com.lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int ZERO_NUMBER = 0;
    private static final int LOTTO_WINNING_NUMBER_COUNT = 6;

    List<Integer> numbers = new ArrayList<>();

    public Lotto() {
        List<Integer> shuffleLottoNumbers = new LottoNumbers().shuffle();
        for (int i = ZERO_NUMBER; i < LOTTO_WINNING_NUMBER_COUNT; i++) {
            numbers.add(shuffleLottoNumbers.get(i));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
