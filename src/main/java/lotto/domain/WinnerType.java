package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum WinnerType {

    FIRST(6, false,2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5,false, 1_500_000),
    FOURTH(4,false, 50_000),
    FIFTH(3, false,5_000);

    private final int sameCount;
    private final boolean isMatchBonus;
    private final int prize;

    WinnerType(int sameCount, boolean isMatchBonus, int prize) {
        this.sameCount = sameCount;
        this.isMatchBonus = isMatchBonus;
        this.prize = prize;
    }

    public static Optional<WinnerType> findByCount(int count, boolean isMatchBonus) {
        return Arrays.stream(WinnerType.values())
                .filter(o -> isMatch(count, isMatchBonus, o))
                .findFirst();
    }

    private static boolean isMatch(int count, boolean isMatchBonus, WinnerType o) {
        return o.getSameCount() == count && o.isMatchBonus == isMatchBonus;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getPrize() {
        return prize;
    }

    public int calculatePrize(Integer number) {
        return prize * number;
    }
}
