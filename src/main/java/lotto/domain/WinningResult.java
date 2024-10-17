package lotto.domain;

import java.util.*;

public class WinningResult {

    private final Map<LottoRank, Integer> staticsMap;

    public WinningResult(Map<LottoRank, Integer> staticsMap) {
        this.staticsMap = staticsMap;
    }

    public WinningResult() {
        this(new HashMap<>());
    }

    public WinningResult(List<LottoRank> staticsList) {
        this();
        staticsList.forEach(this::incrementMatchCount);
    }

    public WinningResult(LottoRank... ranks) {
        this();
        Arrays.stream(ranks)
                .forEach(this::incrementMatchCount);
    }

    public Map<LottoRank, Integer> getStaticsList() {
        return Collections.unmodifiableMap(staticsMap);
    }

    public void incrementMatchCount(LottoRank rank) {
        staticsMap.putIfAbsent(rank, staticsMap.getOrDefault(rank, 0) + 1);
    }


    public double calculateProfitRate(int purchaseAmount) {
        return (double) calculateProfitAmount() / purchaseAmount;
    }


    private int calculateProfitAmount() {
        return staticsMap.keySet()
                .stream()
                .mapToInt(rank -> rank.calculatePrize(staticsMap.get(rank)))
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResult result = (WinningResult) o;
        return Objects.equals(staticsMap, result.staticsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staticsMap);
    }
}
