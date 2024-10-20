package lotto.enumeration;

import lotto.domain.InputNumber;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.Objects;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int count;
    private final int price;

    Rank(final int count, final int price) {
        this.count = count;
        this.price = price;
    }

    public static Rank rank(final Lotto lotto, final InputNumber inputNumber) {
        int matchCount = lotto.countWinningNumbers(inputNumber);
        if (matchCount == SECOND.count && lotto.containsBonusNumber(inputNumber)) {
            return SECOND;
        }
        return rank(matchCount);
    }

    private static Rank rank(final int count) {
        return Arrays.stream(values())
                .filter(rank -> Objects.equals(rank.count, count))
                .findFirst()
                .orElse(Rank.MISS);
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
