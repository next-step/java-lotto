package com.jaeyeonling.lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {

    private static final int INCREMENT_MATCH_COUNT = 1;

    private final WinningLotto winningLotto;

    public LottoAnalyzer(final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoGameReport analyze(final List<Lotto> lottos) {
        return new LottoGameReport(countOfEachLottoPrizeByLottos(lottos));
    }

    private Map<LottoPrize, Integer> countOfEachLottoPrizeByLottos(final List<Lotto> lottos) {
        final Map<LottoPrize, Integer> countOfEachLottoPrize = new EnumMap<>(LottoPrize.class);
        for (final Lotto lotto : lottos) {
            final LottoPrize prize = winningLotto.match(lotto);
            countLottoPrize(countOfEachLottoPrize, prize);
        }

        return countOfEachLottoPrize;
    }

    private void countLottoPrize(final Map<LottoPrize, Integer> countOfEachLottoPrize,
                                 final LottoPrize prize) {
        countOfEachLottoPrize.merge(prize, INCREMENT_MATCH_COUNT, Integer::sum);
    }
}
