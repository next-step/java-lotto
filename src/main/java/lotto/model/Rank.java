package lotto.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    ONE(6, 2_000_000_000),
    TWO(5, 30_000_000),
    THREE(5, 1_500_000),
    FOUR(4, 50_000),
    FIVE(3, 5_000),
    NO_MATCH(0, 0);

    private final int ballCount;
    private final int reward;

    Rank(int ballCount, int reward) {
        this.ballCount = ballCount;
        this.reward = reward;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getReward() {
        return reward;
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

    public static Rank find(int ballCount) {
        return ranks().stream()
                .filter(rank -> rank.sameBallCount(ballCount))
                .findFirst()
                .orElse(Rank.NO_MATCH);
    }

    private boolean sameBallCount(int ballCount) {
        return this.ballCount == ballCount;
    }
}

