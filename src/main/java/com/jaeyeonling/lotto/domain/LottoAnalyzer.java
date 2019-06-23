package com.jaeyeonling.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {

    private static final int DEFAULT_MATCH_COUNT = 0;
    private static final int INCREMENT_MATCH_COUNT = 1;

    private final Lotto winningLotto;

    public LottoAnalyzer(final Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoGameReport analyze(final List<Lotto> lottos) {
        return new LottoGameReport(generateMatchCountByLottoPrize(lottos));
    }

    private Map<LottoPrize, Integer> generateMatchCountByLottoPrize(final List<Lotto> lottos) {
        final Map<LottoPrize, Integer> matchCountByLottoPrize = new HashMap<>();
        for (final Lotto lotto : lottos) {
            final LottoPrize prize = findLottoPrizeByLotto(lotto);
            incrementPrizeMatchCount(matchCountByLottoPrize, prize);
        }

        return matchCountByLottoPrize;
    }

    private LottoPrize findLottoPrizeByLotto(final Lotto lotto) {
        final int countOfMatch = winningLotto.countOfMatch(lotto);
        return LottoPrize.valueOf(countOfMatch);
    }

    private void incrementPrizeMatchCount(final Map<LottoPrize, Integer> matchCountByLottoPrize,
                                          final LottoPrize prize) {
        final int currentMatchCount = matchCountByLottoPrize.getOrDefault(prize, DEFAULT_MATCH_COUNT);
        matchCountByLottoPrize.put(prize, currentMatchCount + INCREMENT_MATCH_COUNT);
    }
}
