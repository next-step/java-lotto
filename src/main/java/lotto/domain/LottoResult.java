package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;

    private final Map<Rank, Integer> rankCounts = new HashMap<>();
    private final int buyAmount;

    public LottoResult(List<Lotto> lottoList, Lotto winnerLotto, LottoNumber bonusNumber, int buyAmount) {
        this.buyAmount = buyAmount;

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
        return rankCounts.entrySet().stream()
                .map(
                        (entry) -> entry.getKey().getWinningMoney() * entry.getValue()
                )
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int getSameLottoCount(int sameCount) {
        return rankCounts.getOrDefault(Rank.valueOf(sameCount, false), INITIAL_COUNT);
    }

    public double getRewardRate() {
        return (double) getTotalReward() / buyAmount;
    }
}
