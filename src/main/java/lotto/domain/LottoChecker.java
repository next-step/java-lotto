package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private static final Map<PrizeLevel, Integer> statistics = new EnumMap<>(PrizeLevel.class);

    private final WinningLotto winningLotto;

    static {
        for (PrizeLevel prizeLevel : PrizeLevel.values()) {
            statistics.put(prizeLevel, 0);
        }
    }

    public LottoChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;

    }

    public LottoWinningStatistics check(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            PrizeLevel prizeLevel = winningLotto.countMatchingNumbers(lotto);
            statistics.put(prizeLevel, statistics.get(prizeLevel) + 1);
        }

        return new LottoWinningStatistics(statistics);
    }
}
