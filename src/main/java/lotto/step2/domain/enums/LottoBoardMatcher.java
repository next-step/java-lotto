package lotto.step2.domain.enums;

import java.util.Arrays;
import java.util.Map;

public enum LottoBoardMatcher {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final long matchCount;
    private final int winningBonus;

    LottoBoardMatcher(long matchCount, int winningBonus) {
        this.matchCount = matchCount;
        this.winningBonus = winningBonus;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public static int getWinningBonus(long matchCount) {
        return Arrays.stream(LottoBoardMatcher.values())
            .filter(i ->
                i.matchCount == matchCount
            ).findFirst()
            .orElse(null)
            .winningBonus;
    }

    public static double winningRatio(Map<Long, Long> map) {
        long lottoAmount = map.values()
            .stream()
            .mapToLong(count -> count)
            .sum() * 1000;
        double winningBonusTotal = Arrays.stream(LottoBoardMatcher.values())
            .filter(boardMatcher -> map.containsKey(boardMatcher.matchCount))
            .mapToDouble(boardMatcher -> boardMatcher.winningBonus * map.get(boardMatcher.matchCount))
            .sum();

        return winningBonusTotal / lottoAmount;
    }
}
