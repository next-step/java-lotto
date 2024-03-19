package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    ONE(6, 2_000_000_000, false),
    TWO(5, 30_000_000, true),
    THREE(5, 1_500_000, false),
    FOUR(4, 50_000, false),
    FIVE(3, 5_000, false),
    NO_MATCH(0, 0, false);

    private final int ballCount;
    private final int reward;
    private final boolean matchBonus;

    Rank(int ballCount, int reward, boolean matchBonus) {
        this.ballCount = ballCount;
        this.reward = reward;
        this.matchBonus = matchBonus;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    private static final List<Rank> sortedRank;

    static {
        sortedRank = Stream.of(values())
                .filter(rank -> !rank.equals(NO_MATCH))
                .sorted(Comparator.comparingInt(value -> value.reward))
                .collect(Collectors.toList());
    }

    public static List<Rank> ranks() {
        return Collections.unmodifiableList(sortedRank);
    }

    public static Rank findRank(int ballCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isSame(ballCount, matchBonus))
                .findFirst()
                .orElse(Rank.NO_MATCH);
    }

    public boolean isSame(int ballCount, boolean matchBonus) {
        return this.ballCount == ballCount && (matchBonus || !this.matchBonus);
    }

    public boolean isTwo() {
        return this == Rank.TWO;
    }
}

