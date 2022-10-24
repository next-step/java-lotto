package com.nextstep.lotto.lottoGame.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    static final int LOTTO_TICKET_PRICE = 1000;
    private static final String INVALID_NUMBERS_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private final Set<Integer> lottoNumbers;

    public LottoTicket() {
        this(randomNumbers());
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBERS_MESSAGE);
        }
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    private static List<Integer> randomNumbers() {
        List<Integer> range = IntStream.range(RANGE_START, RANGE_END)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(range);
        return range.subList(0, 6);
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    public Rank rank(final WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.getMatchCount(lottoNumbers);
        boolean matchBonus = winningNumbers.isMatchBonus(lottoNumbers);
        return Rank.rank(matchCount, matchBonus);
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numberList = new ArrayList<>(lottoNumbers);
        Collections.sort(numberList);
        return numberList;
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoTicket that = (LottoTicket) o;
        return lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }
}
