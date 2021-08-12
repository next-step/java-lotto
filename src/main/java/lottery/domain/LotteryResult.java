package lottery.domain;

import lottery.dto.LotteryResultDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LotteryResult {
    BLANK("꽝", 0, false, new Money(0)),
    THREE_MATCHES("3개 일치", 3, false, new Money(5000)),
    FOUR_MATCHES("4개 일치", 4, false, new Money(50000)),
    FIVE_MATCHES("5개 일치", 5, false, new Money(1500000)),
    FIVE_AND_BONUS_MATCHES("5개 일치, 보너스 볼 일치", 5, true, new Money(30000000)),
    SIX_MATCHES("6개 일치", 6, false, new Money(2000000000));

    private static final List<LotteryResult> LOTTERY_RESULTS = Arrays.stream(values())
            .sorted(LotteryResult::compare)
            .collect(Collectors.toList());

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

    public static LotteryResult getLotteryResult(final int match, final boolean bonus) {
        return LOTTERY_RESULTS.stream()
                .filter(lotteryResult -> lotteryResult.isEqualTo(match, bonus))
                .findFirst()
                .orElse(BLANK);
    }

    private static int compare(final LotteryResult o1, final LotteryResult o2) {
        return o1.match == o2.match
                ? compareBonus(o1, o2)
                : o1.match - o2.match;
    }

    private static int compareBonus(final LotteryResult o1, final LotteryResult o2) {
        return o1.bonus
                ? -1
                : (o2.bonus ? 1 : 0);
    }

    private boolean isEqualTo(final int match, final boolean bonus) {
        return this.match == match
                && this.bonus == (bonus && this.bonus);
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

}
