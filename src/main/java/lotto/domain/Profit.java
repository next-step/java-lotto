package lotto.domain;

import static lotto.LottoApplication.LOTTO_COST;

public class Profit {

    private final double profitRate;

    public Profit(Ranks ranks, Lottos lottos) {
        this.profitRate = calculateProfitRate(ranks, lottos);
    }

    public double getProfitRate() {
        return profitRate;
    }

    private double calculateProfitRate(Ranks ranks, Lottos lottos) {
        // 수익률을 계산한다.
        int totalReward = ranks.of().stream()
                .filter(rank -> Reward.fromMatchingCount(rank.getMatchingNumberCount()) != Reward.MISS)
                .mapToInt(rank -> Reward.fromMatchingCount(rank.getMatchingNumberCount()).getReward() * rank.getMatchingLottosCount())
                .sum();

        return (double) totalReward / (lottos.of().size() * LOTTO_COST);
    }
}
