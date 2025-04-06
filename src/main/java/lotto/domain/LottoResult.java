package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private static final int NO_MATCH = 0;
    private static final int FIRST_INDEX = 1;

    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        this.compareAll(lottos, winningLotto);
    }

    private void compareAll(Lottos lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos.getValues()) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();

            Rank.valueOf(matchCount)
                    .ifPresent(rank -> results.put(rank, results.getOrDefault(rank, NO_MATCH) + FIRST_INDEX));
        }
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalReward = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();

        return (double) totalReward / purchaseAmount;
    }
}
