package lottery.domain.lottery;

import lottery.dto.LotteryResultDto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LotteryResult {
    BLANK("꽝", 0 , 0),
    THREE_MATCHES("3개 일치", 3, 5000),
    FOUR_MATCHES("4개 일치", 4, 50000),
    FIVE_MATCHES("5개 일치", 5, 1500000),
    SIX_MATCHES("6개 일치", 6, 2000000000);

    private static final Map<Integer, LotteryResult> LOTTERY_RESULTS = Arrays.stream(LotteryResult.values())
            .collect(Collectors.toMap(LotteryResult::getScore, Function.identity()));

    private final String explanation;
    private final int score;
    private final int cashPrize;

    LotteryResult(final String explanation, final int score, final int cashPrize) {
        this.explanation = explanation;
        this.score = score;
        this.cashPrize = cashPrize;
    }

    public static LotteryResult getLotteryResult(int score) {
        return LOTTERY_RESULTS.getOrDefault(score, BLANK);
    }

    public static boolean notBlank(LotteryResult lotteryResult) {
        return !lotteryResult.equals(BLANK);
    }

    public long getTotalCashPrize(long count) {
        return count * cashPrize;
    }

    public LotteryResultDto toDto(long count) {
        return new LotteryResultDto(explanation, cashPrize, (int) count);
    }

    private int getScore() {
        return score;
    }
}
