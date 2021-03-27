package lotto.domain;

import lotto.enums.WinningRank;

import java.util.*;

public class RanksCount {
    private static final int INIT = 0;
    private static final int MATCHED_COUNT_MIN = 3;
    private static final int PLUS = 1;
    private final TreeMap<WinningRank, Integer> ranksCount;

    public RanksCount() {
        this.ranksCount = new TreeMap<>(Comparator.comparingInt(WinningRank::matchedCount));
        init();
    }

    public void add(WinningRank rank) {
        if (rank.equals(WinningRank.ETC)) {
            return;
        }

        ranksCount.put(rank, ranksCount.get(rank) + PLUS);
    }

    public void add(List<WinningRank> ranks) {
        for (WinningRank rank : ranks) {
            add(rank);
        }
    }

    public int countOf(WinningRank rank) {
        return ranksCount.get(rank);
    }

    public Map<WinningRank, Integer> ranksCount() {
        return Collections.unmodifiableMap(ranksCount);
    }

    private void init() {
        Arrays.stream(WinningRank.values())
                .filter(rank -> rank.matchedCount() >= MATCHED_COUNT_MIN)
                .forEach(rank -> ranksCount.put(rank, INIT));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RanksCount ranksCount1 = (RanksCount) o;
        return Objects.equals(ranksCount, ranksCount1.ranksCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranksCount);
    }
}
