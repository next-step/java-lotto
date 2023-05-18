package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Rank {

    NONE(0, new Money(0)),
    FOURTH(3, new Money(5_000)),
    THIRD(4, new Money(1_500_000)),
    SECOND(5, new Money(1_500_000)),
    BONUS_RANK(5, new Money(30_000_000)),
    FIRST(6, new Money(2_000_000_000));

    public static final int BONUS_RANK_COUNT = 5;

    private final int count;
    private final Money prize;

    Rank(int count, Money prize) {
        this.count = count;
        this.prize = prize;
    }

    public static Rank findByCount(int count, boolean hasBonusBall) {
        if (count == BONUS_RANK_COUNT && hasBonusBall) {
            return BONUS_RANK;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(count))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(int count) {
        return this.count == count;
    }

    public static Rank of(int count) {
        return Arrays.stream(values())
                .filter(rank -> rank.count == count)
                .findFirst()
                .orElse(NONE);
    }

    public static Map<Rank, Integer> initLottoResult() {
        return Arrays.stream(values())
                .filter(rank -> rank.count >= 0)
                .collect(Collectors.toMap(Function.identity(), o -> 0));
    }

    public int count() {
        return this.count;
    }

    public int prize() {
        return this.prize.amount();
    }
}
