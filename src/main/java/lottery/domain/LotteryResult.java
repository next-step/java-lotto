package lottery.domain;

import lottery.dto.LotteryResultDto;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LotteryResult {
    BLANK("꽝", 0, false, new Money(0)),
    THREE_MATCHES("3개 일치", 3, false, new Money(5000)),
    FOUR_MATCHES("4개 일치", 4, false, new Money(50000)),
    FIVE_MATCHES("5개 일치", 5, false, new Money(1500000)),
    FIVE_AND_BONUS_MATCHES("5개 일치, 보너스 볼 일치", 5, true, new Money(30000000)),
    SIX_MATCHES("6개 일치", 6, false, new Money(2000000000));

    private static final Map<String, LotteryResult> LOTTERY_RESULTS = Arrays.stream(LotteryResult.values())
            .collect(Collectors.toMap(LotteryResult::getKey, Function.identity()));

    private final String explanation;
    private final int match;
    private final boolean bonus;
    private final Money cashPrize;

    LotteryResult(final String explanation, final int match, final boolean bonus, final Money cashPrize) {
        this.explanation = explanation;
        this.match = match;
        this.bonus = bonus;
        this.cashPrize = cashPrize;
    }

    public static LotteryResult getLotteryResult(final int match) {
        return getLotteryResult(match, false);
    }

    public static LotteryResult getLotteryResult(final int match, final boolean bonus) {
        return LOTTERY_RESULTS.getOrDefault(getKey(match, bonus), BLANK);
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

    private String getKey() {
        return getKey(match, bonus);
    }

    private static String getKey(final int match, final boolean bonus) {
        return Stream.of(match, validateBonusAndGet(match, bonus))
                .map(String::valueOf)
                .collect(Collectors.joining("_"));
    }

    private static boolean validateBonusAndGet(final int match, final boolean bonus) {
        return match == FIVE_AND_BONUS_MATCHES.match && bonus;
    }

}
