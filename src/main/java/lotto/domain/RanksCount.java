package lotto.domain;

import lotto.enums.WinningRank;

import java.util.*;
import java.util.stream.Collectors;

public class RanksCount {
    private static final int INIT = 0;
    private static final int MATCHED_COUNT_MIN = 3;
    private static final int PLUS = 1;
    private final Map<WinningRank, Integer> ranksCount;

    public RanksCount() {
        this.ranksCount = initialValue();
    }

    public void add(WinningRank rank) {
        if (rank.equals(WinningRank.ETC)) {
            return;
        }

        ranksCount.put(rank, ranksCount.get(rank) + PLUS);
    }

    public TotalPrize totalPrize() {
        List<Prize> totalPrize = ranksCount.entrySet()
                .stream()
                .map(rank -> rank.getKey().multiply(rank.getValue()))
                .map(Prize::new)
                .collect(Collectors.toList());

        return new TotalPrize(totalPrize);
    }

    public Iterable<? extends Map.Entry<WinningRank, Integer>> entrySet() {
        return ranksCount.entrySet();
    }

    private TreeMap<WinningRank, Integer> initialValue() {
        TreeMap<WinningRank, Integer> ranksCount = new TreeMap<>(Comparator.comparing(WinningRank::matchedCount)
                .thenComparing(WinningRank::prize));

        Arrays.stream(WinningRank.values())
                .filter(rank -> rank.matchedCount().isGreaterOrEqualThan(MATCHED_COUNT_MIN))
                .forEach(rank -> ranksCount.put(rank, INIT));

        return ranksCount;
    }
}
