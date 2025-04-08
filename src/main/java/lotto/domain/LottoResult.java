package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private static final int FIRST_INDEX = 1;

    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        this.compareAll(lottos, winningLotto);
    }

    private void compareAll(Lottos lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos.getValues()) {
            int matchCount = lotto.countMatchWith(winningLotto);
            Rank rank = Rank.from(matchCount);

            if (rank.isWin()) {
                results.put(rank, results.getOrDefault(rank, 0) + FIRST_INDEX);
            }
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
