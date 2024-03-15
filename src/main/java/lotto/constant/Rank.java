package lotto.constant;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    ONE(6, 2_000_000_000),
    TWO(5, 1_500_000),
    THREE(4, 50_000),
    FOUR(3, 5_000);

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
                .sorted(Comparator.comparingInt(value -> value.ballCount))
                .collect(Collectors.toList());
    }

    public static List<Rank> ranks() {
        return Collections.unmodifiableList(sortedRank);
    }

    // 수익률 = 총 수익 / 총 비용
    public static double rateOfReturn(Map<Integer, Integer> resultMap, int capital) {
        return (double) revenue(resultMap) / capital;
    }

    private static long revenue(Map<Integer, Integer> resultMap) {
        return ranks().stream()
                .filter(rank -> resultMap.getOrDefault(rank.ballCount, 0) != 0)
                .map(rank -> resultMap.get(rank.ballCount) * rank.reward)
                .mapToLong(Integer::longValue)
                .sum();
    }
}

