package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, BigDecimal.valueOf(2_000_000_000)),
    SECOND(5, BigDecimal.valueOf(30_000_000)),
    THIRD(5, BigDecimal.valueOf(1_500_000)),
    FORTH(4, BigDecimal.valueOf(50_000)),
    FIFTH(3, BigDecimal.valueOf(5_000)),
    ZERO(0, BigDecimal.valueOf(0));

    private static final int SECOND_NUMBER = 5;

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
                .findFirst()
                .orElse(ZERO);
    }

    private static boolean isSecond(int count, boolean matchBonus) {
        return count == SECOND_NUMBER && matchBonus;
    }
}
