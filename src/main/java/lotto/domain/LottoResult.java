package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;
    private static final int DEFAULT_WINNING_COUNT = 0;

    private final Map<WinningCase, Integer> winningCounts = new HashMap<>();
    private final int buyAmount;

    public LottoResult(List<Lotto> lottoList, Lotto winnerLotto, int buyAmount) {
        this.buyAmount = buyAmount;

        lottoList.stream().map(lotto -> {
            int numberCount = lotto.sameNumberCount(winnerLotto);
            return new WinningCase(numberCount);
        }).forEach(winningCase -> {
            winningCounts.putIfAbsent(winningCase, INITIAL_COUNT);
            winningCounts.computeIfPresent(winningCase,(key, count) -> ++count);
        });
    }

    public int getTotalReward() {
        return winningCounts.entrySet().stream()
                .map((entry) -> entry.getKey().getReward(entry.getValue()))
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int getSameLottoCount(int sameCount) {
        return winningCounts.getOrDefault(new WinningCase(sameCount), DEFAULT_WINNING_COUNT);
    }

    public double getRewardRate() {
        return (double) getTotalReward() / buyAmount;
    }
}
