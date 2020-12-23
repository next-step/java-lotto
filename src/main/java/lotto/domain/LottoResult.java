package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;
    private static final int DEFAULT_TOTAL_REWARD = 0;

    private final Map<Rank, Integer> rankCounts = new HashMap<>();
    private final int buyAmount;
    private final List<Lotto> lottoList;
    private final Lotto winnerLotto;
    private final LottoNumber bonusNumber;

    public LottoResult(List<Lotto> lottoList, Lotto winnerLotto, LottoNumber bonusNumber, int buyAmount) {
        this.lottoList = lottoList;
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
        this.buyAmount = buyAmount;

        buildRankCounts();
    }

    private void buildRankCounts() {
        lottoList.stream().map(lotto -> {
            int numberCount = lotto.matchNumberCount(winnerLotto);
            boolean matchBonus = lotto.matchBonus(bonusNumber);
            return Rank.valueOf(numberCount, matchBonus);
        }).forEach(rank -> {
            rankCounts.putIfAbsent(rank, INITIAL_COUNT);
            rankCounts.computeIfPresent(rank,(key, count) -> ++count);
        });
    }

    public int getTotalReward() {
        return rankCounts.keySet().stream()
                .map(rank -> rank.getReward(rankCounts.get(rank)))
                .reduce(Integer::sum)
                .orElse(DEFAULT_TOTAL_REWARD);
    }

    public int getRankCount(Rank rank) {
        return rankCounts.getOrDefault(rank, INITIAL_COUNT);
    }

    public double getRewardRate() {
        return (double) getTotalReward() / buyAmount;
    }
}
