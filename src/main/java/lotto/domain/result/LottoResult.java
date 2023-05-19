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

    public void win(Rank matchedRank) {
        for (Rank rank : result.keySet()) {
            plusWinOfCount(matchedRank, rank);
        }
    }

    private void plusWinOfCount(Rank matchedRank, Rank rank) {
        if (matchedRank.equals(rank)) {
            Long winOfCount = result.get(rank);
            winOfCount++;
            result.put(rank, winOfCount);
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Rank rank : result.keySet()) {
            totalPrice = (int) (rank.getReward() * result.get(rank) + totalPrice);
        }
        return totalPrice;
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

    @Override
    public String toString() {
        return "LottoResult{" +
                "result=" + result +
                '}';
    }
}
