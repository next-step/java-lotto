package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public enum LottoRank {
    FIRST(1, 2_000_000_000, Arrays.asList(6), false),
    SECOND(2, 30_000_000, Arrays.asList(5), true),
    THIRD(3, 1_500_000, Arrays.asList(5), false),
    FOURTH(4, 50_000, Arrays.asList(4), false),
    FIFTH(5, 5_000, Arrays.asList(3), false),
    NONE(0, 0, Arrays.asList(0, 1, 2), false);

    private static final String NOT_MATCH_COUNT = "잘못된 match count 입니다.";
    private final int matchRank;
    private final int prizeMoney;
    private final List<Integer> matchCounts;
    private final boolean matchBonus;

    LottoRank(int matchRank, int prizeMoney, List<Integer> matchCounts, boolean matchBonus) {
        this.matchRank = matchRank;
        this.prizeMoney = prizeMoney;
        this.matchCounts = matchCounts;
        this.matchBonus = matchBonus;
    }

    public int getMatchRank() {
        return matchRank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public List<Integer> getMatchCounts() {
        return matchCounts;
    }

    public static LottoRank matchRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchCounts().contains(matchCount) && (rank.matchBonus == matchBonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_COUNT));
    }

    public static EnumMap<LottoRank, Integer> initializePrizeCount() {
        EnumMap<LottoRank, Integer> prizeCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            prizeCount.put(rank, 0);
        }
        return prizeCount;
    }
}
