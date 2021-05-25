package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigDecimal.valueOf;

public class LottoResult {
    private final int INCREMENT_SIZE = 1;

    private Map<Rank, Integer> value = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            value.put(rank, 0);
        }
    }

    public void put(Rank rank) {
        int existingCount = value.get(rank);
        value.put(rank, existingCount + INCREMENT_SIZE);
    }

    public int get(Rank rank) {
        return value.get(rank);
    }

    public BigDecimal getAllPrize() {
        BigDecimal result = new BigDecimal(0);
        for (Rank each : Rank.values()) {
            BigDecimal eachRankResult = valueOf(each.getPrize()).multiply(valueOf(value.get(each)));
            result = result.add(eachRankResult);
        }
        return result;
    }
}
