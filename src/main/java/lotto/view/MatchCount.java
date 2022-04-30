package lotto.view;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 일치하는 번호 개수에 따른 당첨 금액
 */
public enum MatchCount {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private static final Map<Integer, Integer> MATCH_COUNT_WINNING_AMOUNT_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(
                    it -> it.matchCount,
                    it -> it.winningAmount
            ));

    private final int matchCount;
    private final int winningAmount;

    MatchCount(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static int getWinningAmountWith(int matchCount) {
        return Optional.ofNullable(MATCH_COUNT_WINNING_AMOUNT_MAP.get(matchCount))
                .orElseThrow(IllegalArgumentException::new);
    }
}
