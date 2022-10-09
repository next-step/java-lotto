package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatisticsResult;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatisticsCalculator {

    private LottoStatisticsCalculator() {}

    public static LottoStatisticsResult calculateStatistics(Lotto winningLotto, LottoNumber bonusLottoNumber, List<Lotto> lottos) {
        List<LottoRank> ranks = lottos.stream()
                .map(lotto -> LottoRank.of(winningLotto.countMatchNumbers(lotto), lotto.contains(bonusLottoNumber)))
                .collect(Collectors.toList());
        return LottoStatisticsResult.from(ranks);
    }

}
