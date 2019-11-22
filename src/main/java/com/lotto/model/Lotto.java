package com.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int ZERO_NUMBER = 0;
    private static final int LOTTO_WINNING_NUMBER_COUNT = 6;
    private static final String START_CHARACTER = "[";
    private static final String END_CHARACTER = "]";
    private static final String COMMA_SPACE_CHARACTER = ", ";

    private final List<Integer> numbers = new ArrayList<>();

    private int matchCount = 0;

    public Lotto() {
        List<Integer> shuffleLottoNumbers = new LottoNumbers().shuffle();
        for (int i = ZERO_NUMBER; i < LOTTO_WINNING_NUMBER_COUNT; i++) {
            numbers.add(shuffleLottoNumbers.get(i));
        }
        Collections.sort(numbers);
    }

    public String printNumbers() {
        StringBuilder stringBuilder = new StringBuilder(START_CHARACTER);
        stringBuilder.append(
                numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_SPACE_CHARACTER)));
        stringBuilder.append(END_CHARACTER);
        return stringBuilder.toString();
    }

    public void match(WinningLotto winningLotto) {
        for (int number : numbers) {
            matchCount += winningLotto.match(number);
        }
    }

    public boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int isWinningMoney() {
        return Rank.valueOf(matchCount).getWinningMoney();
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
