package com.jaeyeonling.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LottoAnalyzer {

    private final Map<LottoPrize, Integer> matchCountByLottoPrize = new ConcurrentHashMap<>();
    private final Lotto winningLotto;

    public LottoAnalyzer(final Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void analyze(final List<Lotto> lottos) {
        lottos.forEach(this::analyze);
    }

    public void analyze(final Lotto lotto) {
        final int countOfMatch = winningLotto.countOfMatch(lotto);
        final LottoPrize prize = LottoPrize.valueOf(countOfMatch);

        incrementMatchCount(prize);
    }

    private void incrementMatchCount(final LottoPrize prize) {
        matchCountByLottoPrize.put(prize, matchCountByLottoPrize.getOrDefault(prize, 0) + 1);
    }

    public LottoGameReport getReport() {
        return new LottoGameReport(matchCountByLottoPrize);
    }
}
