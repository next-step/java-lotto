package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatisticsResult;
import lotto.domain.WinningCondition;

import java.util.List;

public class LottoStatisticsCalculator {

    private LottoStatisticsCalculator() {}

    public static LottoStatisticsResult calculateStatistics(WinningCondition winningCondition, List<Lotto> lottos) {
        List<LottoRank> ranks = winningCondition.getRanks(lottos);
        return LottoStatisticsResult.from(ranks);
    }

}
