package step2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum PrizeLevel {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    MISS(0, 0);

    private static final Map<Integer, PrizeLevel> PRIZE_LEVEL_MAP = Arrays.stream(PrizeLevel.values())
            .filter(level -> level != SECOND)
            .collect(Collectors.toMap(PrizeLevel::getMatchCount, Function.identity()));

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

        if (matchedCount == 5) {
            return hasBonus ? PrizeLevel.SECOND : PrizeLevel.THIRD;
        }

        return PRIZE_LEVEL_MAP.getOrDefault(matchedCount, PrizeLevel.MISS);
    }
}
