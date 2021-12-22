package lotto.result;

import java.util.stream.Stream;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchedNumbersCount;
    private final int prize;

    Rank(int matchedNumbersCount, int prize) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.prize = prize;
    }

    public static Rank valueOf(long count, boolean matchedBonusNumber) {
        Rank matchedRank = Stream.of(values())
                .filter(rank -> rank.matchedNumbersCount == count)
                .findFirst()
                .orElse(MISS);

        if (isSecond(matchedBonusNumber, matchedRank)) {
            return SECOND;
        }

        return matchedRank;
    }

    public int matchedNumbersCount() {
        return matchedNumbersCount;
    }

    public int prize() {
        return prize;
    }

    public long totalPrize(Long quantity) {
        return prize * quantity;
    }

    private static boolean isSecond(boolean matchedBonusNumber, Rank matchedRank) {
        return matchedRank == FOURTH && matchedBonusNumber;
    }
}
