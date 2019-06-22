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
        return getLottoGameReport(lottos);
    }

    private LottoGameReport getLottoGameReport(final List<Lotto> lottos) {
        return new LottoGameReport(getMatchCountByLottoPrize(lottos));
    }

    private Map<LottoPrize, Integer> getMatchCountByLottoPrize(final List<Lotto> lottos) {
        final Map<LottoPrize, Integer> matchCountByLottoPrize = new HashMap<>();
        for (final Lotto lotto : lottos) {
            final int countOfMatch = getCountOfMatch(lotto);
            final LottoPrize prize = getLottoPrize(countOfMatch);

            final int currentMatchCount = matchCountByLottoPrize.getOrDefault(prize, DEFAULT_MATCH_COUNT);
            matchCountByLottoPrize.put(prize, currentMatchCount + INCREMENT_MATCH_COUNT);
        }

        return matchCountByLottoPrize;
    }

    private LottoPrize getLottoPrize(final int countOfMatch) {
        return LottoPrize.valueOf(countOfMatch);
    }

    private int getCountOfMatch(final Lotto lotto) {
        return winningLotto.countOfMatch(lotto);
    }
}
