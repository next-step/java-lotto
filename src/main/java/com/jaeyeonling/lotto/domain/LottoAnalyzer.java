package com.jaeyeonling.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {

    private static final int DEFAULT_MATCH_COUNT = 0;
    private static final int INCREMENT_MATCH_COUNT = 1;

    private final Lotto winningLotto;
    private LottoNumber bonusLottoNumber;

    public LottoAnalyzer(final Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoAnalyzer(final Lotto winningLotto,
                         final LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoGameReport analyze(final List<Lotto> lottos) {
        return new LottoGameReport(countOfEachLottoPrizeByLottos(lottos));
    }

    private Map<LottoPrize, Integer> countOfEachLottoPrizeByLottos(final List<Lotto> lottos) {
        final Map<LottoPrize, Integer> countOfEachLottoPrize = new HashMap<>();
        for (final Lotto lotto : lottos) {
            final LottoPrize prize = matchWithWinningLotto(lotto);
            countLottoPrize(countOfEachLottoPrize, prize);
        }

        return countOfEachLottoPrize;
    }

    private LottoPrize matchWithWinningLotto(final Lotto lotto) {
        final int countOfMatch = winningLotto.countOfMatch(lotto);
        final boolean matchBonus = lotto.contains(bonusLottoNumber);

        return LottoPrize.valueOf(countOfMatch, matchBonus);
    }

    private void countLottoPrize(final Map<LottoPrize, Integer> countOfEachLottoPrize,
                                 final LottoPrize prize) {
        final int currentMatchCount = countOfEachLottoPrize.getOrDefault(prize, DEFAULT_MATCH_COUNT);
        countOfEachLottoPrize.put(prize, currentMatchCount + INCREMENT_MATCH_COUNT);
    }
}
