package com.nextstep.lotto.domain;

import java.util.ArrayList;
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

    public LottoStatistics getStatistics(String winningNumberString, int bonusNumber) {
        WinningLotto winningLotto = parseToLotto(winningNumberString, bonusNumber);
        List<LottoRank> winnings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            winnings.add(lotto.getWinning(winningLotto));
        }
        return new LottoStatistics(winnings);
    }

    private WinningLotto parseToLotto(String winningNumberString, int bonusNumber) {
        if ( winningNumberString == null || "".equals(winningNumberString) ) {
            throw new IllegalArgumentException("winning numbers are not allowed empty value");
        }
        String[] numbers = winningNumberString.split(DELIMITER);
        return new WinningLotto(parseToList(numbers), bonusNumber);
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
