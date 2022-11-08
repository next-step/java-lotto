package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, BigDecimal.valueOf(2000000000)),
    SECOND(5, BigDecimal.valueOf(30000000)),
    THIRD(5, BigDecimal.valueOf(1500000)),
    FORTH(4, BigDecimal.valueOf(50000)),
    FIFTH(3, BigDecimal.valueOf(5000)),
    SIXTH(2, BigDecimal.valueOf(0)),
    SEVENTH(1, BigDecimal.valueOf(0)),
    ZERO(0, BigDecimal.valueOf(0));

    private final int count;
    private final BigDecimal amount;

    Rank(int count, BigDecimal amount) {
        this.count = count;
        this.amount = amount;
    }

    public static Rank getResultRank(Lotto lotto) {
        return lotto.getRank();
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public static Rank getRank(int count, boolean matchBonus) {
        if (isSecond(count, !matchBonus)) {
            return Rank.THIRD;
        }

        return Arrays.stream(values())
                .filter(cnt -> cnt.getCount() == count)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("숫자가 틀립니다."));
    }

    private static boolean isSecond(int count, boolean matchBonus) {
        return count == 5 && matchBonus;
    }
}
