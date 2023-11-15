package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIRST(6, new Amount(2_000_000_000)),
    SECOND(5, new Amount(30_000_000)),
    THIRD(5, new Amount(1_500_000)),
    FOURTH(4, new Amount(50_000)),
    FIFTH(3, new Amount(5_000));

    public static final String INVALID_COUNT = "올바른 당첨수가 아닙니다.";
    private int count;
    private Amount price;

    Rank(final int count, final Amount price) {
        this.count = count;
        this.price = price;
    }

    static boolean isWinning(final int rightNumber) {
        return Arrays.stream(values())
                .anyMatch(v -> v.count == rightNumber);
    }

    static Rank ofRightNumber(final int rightNumber, boolean bonusMatch) {
        Optional<Rank> rankOptional = Arrays.stream(values())
                .filter(rank -> rank.count == rightNumber)
                .findFirst();

        return rankOptional.map(rank -> {
            if (rightNumber == 5 && bonusMatch) {
                return Rank.SECOND;
            } else if (rightNumber == 5) {
                return Rank.THIRD;
            }

            return rank;
        }).orElseThrow(() -> new IllegalArgumentException(INVALID_COUNT));
    }

    public Amount getAmount() {
        return price;
    }

    public Amount multiply(final int count) {
        return this.price.multiply(count);
    }
}
