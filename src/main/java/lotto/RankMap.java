package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RankMap {

    private final Map<MatchedCount, Integer> lottoNumberMatchedMap = new HashMap<>();

    public RankMap(List<MatchedCount> counts) {
        counts.forEach(this::add);
    }

    public Map<MatchedCount, Integer> getMap() {
        return lottoNumberMatchedMap;
    }

    private void add(MatchedCount key) {
        if (!lottoNumberMatchedMap.containsKey(key)) {
            lottoNumberMatchedMap.put(key, 1);
            return;
        }

        Integer value = lottoNumberMatchedMap.get(key);
        lottoNumberMatchedMap.put(key, value + 1);
    }

    public Prizes getAllPrizes() {
        return new Prizes(
                lottoNumberMatchedMap.entrySet().stream()
                        .map(e -> RANK.receivePrize(e.getKey(),e.getValue()))
                        .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankMap)) return false;
        RankMap rankMap = (RankMap) o;
        return Objects.equals(lottoNumberMatchedMap, rankMap.lottoNumberMatchedMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberMatchedMap);
    }
}
