package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

    private static final int DEFAULT_VALUE = 0;
    private static final int INCREMENT_VALUE = 1;

    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        this(new HashMap<>());
        Arrays.stream(LottoRank.values())
            .forEach(this::putRank);
    }

    public LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public LottoResult(LottoRank... ranks) {
        this();
        Arrays.stream(ranks).forEach(
            this::putRank);
    }

    public double calculateReturnRate(int payed) {
        Money totalPrize = Money.zero();
        for (LottoRank rank : result.keySet()) {
            totalPrize.sum(rank.getPrize() * result.get(rank));
        }
        return totalPrize.calculateReturnRate(payed);
    }

    public int countRank(LottoRank rank) {
        return result.getOrDefault(rank, DEFAULT_VALUE);
    }

    public void increaseRankCount(int matchCount, boolean matchBonus) {
        LottoRank rank = LottoRank.isLottoRank(matchCount, matchBonus);
        putRank(rank);
    }

    private void putRank(LottoRank rank) {
        result.put(rank, result.getOrDefault(rank, DEFAULT_VALUE) + INCREMENT_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
            "result=" + result +
            '}';
    }
}
