package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {

    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int count;
    private final int reward;

    private static final Map<Integer, Integer> rank = Stream.of(values()).collect(Collectors.toMap(Rank::count, Rank::reward));

    Rank(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public int count() {
        return count;
    }

    public int reward() {
        return reward;
    }

    public static int of(int count) {
        return rank.get(count);
    }

    public static List<Integer> getCountList() {
        return Stream.of(values()).map(Rank::count).collect(Collectors.toList());
    }
}
