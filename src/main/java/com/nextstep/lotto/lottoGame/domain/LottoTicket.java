package com.nextstep.lotto.lottoGame.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final String INVALID_NUMBERS_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;

    private final Set<Integer> numbers;

    public LottoTicket() {
        this(randomNumbers());
    }

    public LottoTicket(List<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBERS_MESSAGE);
        }
    }

    private static List<Integer> randomNumbers() {
        List<Integer> range = IntStream.range(RANGE_START, RANGE_END)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(range);
        return range.subList(0, 6);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public Rank rank(List<Integer> winningNumbers) {
        int matchCount = getMatchCount(winningNumbers);
        return Rank.rank(matchCount);
    }

    private int getMatchCount(List<Integer> winningNumbers) {
        Long matchCount = winningNumbers.stream()
                .filter(number -> numbers.contains(number))
                .count();
        return matchCount.intValue();
    }

    public List<Integer> getNumbers() {
        List<Integer> numberList = new ArrayList<>(numbers);
        Collections.sort(numberList);
        return numberList;
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoTicket that = (LottoTicket) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}
