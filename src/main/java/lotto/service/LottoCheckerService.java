package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.PrizeLevel;
import lotto.domain.WinningLotto;

public class LottoCheckerService {
    private static final Map<PrizeLevel, Integer> statistics = new EnumMap<>(PrizeLevel.class);

    private final WinningLotto winningLotto;

    static {
        for (PrizeLevel prizeLevel : PrizeLevel.values()) {
            statistics.put(prizeLevel, 0);
        }
    }

    public LottoCheckerService(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;

    }

    public LottoStatisticsService check(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            PrizeLevel prizeLevel = winningLotto.countMatchingNumbers(lotto);
            statistics.put(prizeLevel, statistics.get(prizeLevel) + 1);
        }

        return new LottoStatisticsService(statistics);
    }
}
