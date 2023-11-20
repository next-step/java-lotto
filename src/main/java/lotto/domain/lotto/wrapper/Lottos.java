package lotto.domain.lotto.wrapper;

import lotto.domain.lotto.LotteryRank;
import lotto.domain.rankcount.RankCountGroup;

import java.util.EnumMap;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Lottos {

    private final List<LottoNumbers> lottos;

    public Lottos(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    public int getNumOfLotto() {
        return this.lottos.size();
    }

    public RankCountGroup groupByRank(WinningNumber winningNumber) {
        return new RankCountGroup(lottos.stream()
            .collect(groupingBy(lotto -> findRank(winningNumber, lotto), () -> new EnumMap<>(LotteryRank.class), counting())));
    }

    private LotteryRank findRank(WinningNumber winningNumber, LottoNumbers lotto) {
        int matchingCount = winningNumber.countMatchingNumbers(lotto);
        boolean bonus = winningNumber.containsBonus(lotto);

        return LotteryRank.findRankBy(matchingCount, bonus);
    }
}
