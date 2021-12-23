package lotto.domain.stat;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.Arrays;

public class LottoResult {

    private LottoRankCountMap rankCountMap;
    private final double profitRate;
    private final Money totalReward;

    private LottoResult(LottoRankCountMap rankCountMap, double profitRate, Money totalReward) {
        this.rankCountMap = rankCountMap;
        this.profitRate = profitRate;
        this.totalReward = totalReward;
    }

    public static LottoResult generate(Lottos purchasedLottos, Lotto winningLotto, Money payedMoney) {
        LottoRankCountMap rankCountMap = LottoRankCountMap.create(purchasedLottos, winningLotto);

        Money totalReward = new Money(Arrays.stream(LottoRank.values())
            .map(rank -> rank.multiplyCountToReward(rankCountMap.get(rank)))
            .reduce(Integer::sum)
            .orElse(0));

        double profitRate = totalReward.divideBy(payedMoney);

        return new LottoResult(rankCountMap, profitRate, totalReward);
    }

    public LottoRankCountMap getRankCountMap() {
        return rankCountMap;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public Money getTotalReward() {
        return totalReward;
    }

}
