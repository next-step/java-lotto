package com.nextstep.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public LottoStatistics getStatistics(List<Integer> winningNumbers) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        for (Lotto lotto : lottos) {
            lottoStatistics.addCount(lotto.getWinning(winningNumbers));
        }
        return lottoStatistics;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
