package lotto.domain.result;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private Map<Rank, Long> result;

    public LottoResult(Map<Rank, Long> result) {
        this.result = result;
    }

    public static LottoResult of(Rank rank) {
        Map<Rank, Long> map = new HashMap<>();
        map.put(rank, 0L);
        return new LottoResult(map);
    }

    public void win(Rank rank) {
        for (Rank rank1 : result.keySet()) {
            if (rank != rank1) {
                return;
            }
        }

        Long winOfCount = result.get(rank);
        winOfCount++;
        result.put(rank, winOfCount);
    }

    public Rank getKey() {
        return result.entrySet().stream().findFirst().get().getKey();
    }

    public Long getValue() {
        return result.entrySet().stream().findFirst().get().getValue();
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
