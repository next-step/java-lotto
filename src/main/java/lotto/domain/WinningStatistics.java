package lotto.domain;

import java.util.EnumMap;

public class WinningStatistics {

    private final EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    public WinningStatistics() {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }
}
