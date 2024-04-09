package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .filter(rank -> rank.isBonusOrNotSecond(isBonus))
                .findFirst()
                .orElse(MISS);
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean isBonusOrNotSecond(boolean isBonus) {
        return !isSecond() || isBonus;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public int countSameMatch(List<Rank> ranks) {
        return (int) ranks.stream()
                .filter(rank -> rank == this)
                .count();
    }

    public static List<Rank> availableRanks() {
        List<Rank> ranks = Arrays.stream(Rank.values())
                .filter(rank -> rank != MISS)
                .collect(Collectors.toList());
        Collections.reverse(ranks);
        return ranks;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
