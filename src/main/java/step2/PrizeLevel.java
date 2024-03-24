package step2;

import java.util.Arrays;

public enum PrizeLevel {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    MISS(0, 0);

    private final int matchCount;
    private final int prizeAmount;

    PrizeLevel(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static PrizeLevel calculateWinningTier(Lotto lotto, WinningNumbers winningNumbers) {
        int matchedCount = lotto.matchedNumbersCount(winningNumbers.getNumbers());
        boolean hasBonus = lotto.hasBonus(winningNumbers.getBonusNumber());

        if (matchedCount == 5 && hasBonus) {
            return PrizeLevel.SECOND;
        }

        return Arrays.stream(PrizeLevel.values())
                .filter(level -> level.getMatchCount() == matchedCount)
                .findFirst()
                .orElse(PrizeLevel.MISS);
    }
}
