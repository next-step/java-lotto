package lotto.domain.result;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<Rank, Long> result;

    public LottoResult(Map<Rank, Long> result) {
        this.result = result;
    }

    public static LottoResult of() {
        return new LottoResult(Arrays.stream(Rank.values()).collect(Collectors.toMap(rank -> rank, rank -> rank.initialRank())));
    }

    public Map<Rank, Long> getLottoResult() {
        return Collections.unmodifiableMap(result);
    }

    public void plusWinOfCount(Rank rank) {
        result = result.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingLong(entry -> entry.getKey().equals(rank) ? entry.getValue() + 1L : entry.getValue())
                ));
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Rank rank : result.keySet()) {
            totalPrice = (int) (rank.getReward() * result.get(rank) + totalPrice);
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
