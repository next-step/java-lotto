package lotto.domain;

import java.util.Arrays;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult(final Map<Rank, Integer> result) {
        this.result = result;
    }

    public int findByKey(final Rank rank) {
        return result.get(rank);
    }

    public long addTotalMoney() {
        return Arrays.stream(Rank.values())
                .mapToLong(rank -> rank.multiplyMoney(result.get(rank)))
                .sum();
    }
}
