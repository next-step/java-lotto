package lotto.domain.result;

import lotto.domain.Rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int INIT_COUNT = 0;
    private final Map<Rank, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
        putInitMatchPrize();
    }

    public void addRank(final Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int findByKey(final Rank rank) {
        return result.get(rank);
    }

    public long sumWinningMoney() {
        return Arrays.stream(Rank.values())
                .mapToLong(rank -> rank.multiplyMoney(result.get(rank)))
                .sum();
    }

    private void putInitMatchPrize() {
        Arrays.stream(Rank.values())
                .forEach(matchPrize -> result.put(matchPrize, INIT_COUNT));
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
