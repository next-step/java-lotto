package com.nextstep.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private static final String DELIMITER = ",";
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public LottoStatistics getStatistics(String winningNumberString) {
        Lotto winningLotto = parseToLotto(winningNumberString);
        LottoStatistics lottoStatistics = new LottoStatistics();
        for (Lotto lotto : lottos) {
            lottoStatistics.addCount(lotto.getWinning(winningLotto));
        }
        return lottoStatistics;
    }

    private Lotto parseToLotto(String winningNumberString) {
        if ( winningNumberString == null || "".equals(winningNumberString) ) {
            throw new IllegalArgumentException("winning numbers are not allowed empty value");
        }
        String[] numbers = winningNumberString.split(DELIMITER);

        return new Lotto(parseToList(numbers));
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
