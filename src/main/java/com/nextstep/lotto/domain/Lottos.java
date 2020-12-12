package com.nextstep.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private static final String DELIMITER = ",";

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public LottoStatistics getStatistics(String winningNumberString) {
        List<Integer> winningNumbers = parseToList(winningNumberString);
        LottoStatistics lottoStatistics = new LottoStatistics();
        for (Lotto lotto : lottos) {
            lottoStatistics.addCount(lotto.getWinning(winningNumbers));
        }
        return lottoStatistics;
    }

    private List<Integer> parseToList(String winningNumberString) {
        if ( winningNumberString == null || "".equals(winningNumberString) ) {
            throw new IllegalArgumentException("winning numbers are not allowed empty value");
        }
        String[] numbers = winningNumberString.split(DELIMITER);

        if (numbers.length != Lotto.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("number count shoud be " + Lotto.LOTTO_NUMBER_COUNT);
        }
        return parseToList(numbers);
    }

    private List<Integer> parseToList(String[] numbers) {
        return Stream.of(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
