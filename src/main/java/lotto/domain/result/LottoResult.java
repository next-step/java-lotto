package lotto.domain.result;

import java.util.*;
import java.util.function.Function;
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

    public void resetResult(Rank rank) {
        result = Rank.convertToList().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingLong(value -> value.equals(rank) ? result.get(value) + 1L : result.get(value))));
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
