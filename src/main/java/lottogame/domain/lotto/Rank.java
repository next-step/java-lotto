package lottogame.domain.lotto;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(Rank.FIRST_PLACE, 2_000_000_000, (matchCount, matchBonus) -> matchCount == 6),
    SECOND(Rank.SECOND_PLACE, 30_000_000, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    THIRD(Rank.THIRD_PLACE, 1_500_000, (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    FOURTH(Rank.FOURTH_PLACE, 50_000, (matchCount, matchBonus) -> matchCount == 4),
    FIFTH(Rank.FIFTH_PLACE, 5_000, (matchCount, matchBonus) -> matchCount == 3),
    NONE(Rank.NONE_PLACE, 0, (matchCount, matchBonus) -> matchCount < 3);

    public static final int FIRST_PLACE = 6;
    public static final int SECOND_PLACE = 5;
    public static final int THIRD_PLACE = 5;
    public static final int FOURTH_PLACE = 4;
    public static final int FIFTH_PLACE = 3;
    public static final int NONE_PLACE = 0;

    private final int matchCount;
    private final double prizeMoney;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(int matchCount, double prizeMoney, BiPredicate<Integer, Boolean> isMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isMatch = isMatch;
    }

    public static Rank from(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch.test(matchCount, matchBonus))
                .findFirst()
                .orElse(Rank.NONE);
    }

    public boolean isNone() {
        return this == NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public double getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isSecond() {
        return this == SECOND;
    }
}
