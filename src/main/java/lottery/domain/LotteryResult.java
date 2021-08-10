package lottery.domain;

import lottery.dto.LotteryResultDto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LotteryResult {
    BLANK("꽝", getTotalMatchScore(0), new Money(0)),
    THREE_MATCHES("3개 일치", getTotalMatchScore(3), new Money(5000)),
    FOUR_MATCHES("4개 일치", getTotalMatchScore(4), new Money(50000)),
    FIVE_MATCHES("5개 일치", getTotalMatchScore(5), new Money(1500000)),
    FIVE_AND_BONUS_MATCHES("5개 일치, 보너스 볼 일치", getTotalMatchScore(5) + getBonusScore(true), new Money(30000000)),
    SIX_MATCHES("6개 일치", getTotalMatchScore(6), new Money(2000000000));


    private static final Map<Integer, LotteryResult> LOTTERY_RESULTS = Arrays.stream(LotteryResult.values())
            .collect(Collectors.toMap(LotteryResult::getScore, Function.identity()));
    private static final int MATCH_SCORE = 10;
    private static final int BONUS_MATCH_SCORE = 5;

    private final String explanation;
    private final int score;
    private final Money cashPrize;

    LotteryResult(final String explanation, final int score, final Money cashPrize) {
        this.explanation = explanation;
        this.score = score;
        this.cashPrize = cashPrize;
    }

    public static int getTotalMatchScore(final int count) {
        return count * MATCH_SCORE;
    }

    public static int getBonusScore(final boolean containBonus) {
        return containBonus
                ? BONUS_MATCH_SCORE
                : 0;
    }

    public static LotteryResult getLotteryResult(final int score) {
        return LOTTERY_RESULTS.getOrDefault(score, BLANK);
    }

    public static boolean notBlank(final LotteryResult lotteryResult) {
        return !lotteryResult.equals(BLANK);
    }

    public long getTotalCashPrize(final long count) {
        return cashPrize.multiply(count);
    }

    public LotteryResultDto toDto(final long count) {
        return new LotteryResultDto(explanation, cashPrize, (int) count);
    }

    private int getScore() {
        return score;
    }
}
