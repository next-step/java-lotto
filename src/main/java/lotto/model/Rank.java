package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);
    private static final Map<Integer, Rank> lotto_rank = new HashMap<>();

    static {
        for (Rank rank : values()) {
            lotto_rank.put(rank.count, rank);
        }
    }

    private final int count;
    private final int reward;

    Rank(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public static Rank of(int count) {
        return lotto_rank.get(count);
    }

    public static Map<Rank, Integer> initLottoResult() {
        return Arrays.stream(values())
                .filter(rank -> rank != NONE)
                .collect(Collectors.toMap(Function.identity(), o -> 0));
    }

    public int count() {
        return this.count;
    }

    public int reward() {
        return this.reward;
    }
}
