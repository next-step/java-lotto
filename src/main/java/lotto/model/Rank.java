package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(1_500_000)),
    THIRD(4, new Money(1_500_000)),
    FOURTH(3, new Money(5_000)),
    NONE(0, new Money(0));
    private static final Map<Integer, Rank> lotto_rank = Arrays.stream(values())
            .collect(Collectors.toMap(Rank::count, Function.identity()));

    private final int count;
    private final Money prize;

    Rank(int count, Money prize) {
        this.count = count;
        this.prize = prize;
    }

    public static Rank of(int count, boolean isWin) {
        if (isWin) {
            return lotto_rank.getOrDefault(count, NONE);
        }

        return NONE;
    }

    public static Rank of(int count) {
        return lotto_rank.getOrDefault(count, NONE);
    }

    public static Map<Rank, Integer> initLottoResult() {
        return Arrays.stream(values())
                .filter(rank -> rank.count >= 0)
                .collect(Collectors.toMap(Function.identity(), o -> 0));
    }

    public int count() {
        return this.count;
    }

    public Money prize() {
        return this.prize;
    }
}
