package lotto.domain.result;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> result;

    public LottoResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static LottoResult of(Rank rank) {
        Map<Rank, Integer> map = new HashMap<>();
        map.put(rank, 0);
        return new LottoResult(map);
    }

    public void win(Rank rank) {
        for (Rank rank1 : result.keySet()) {
            if (rank != rank1) {
                return;
            }
        }

        Integer integer = result.get(rank);
        integer++;
        result.put(rank, integer);
    }

    public Rank getKey() {
        return result.entrySet().stream().findFirst().get().getKey();
    }

    public Integer getValue() {
        return result.entrySet().stream().findFirst().get().getValue();
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "result=" + result +
                '}' + "\n";
    }
}
