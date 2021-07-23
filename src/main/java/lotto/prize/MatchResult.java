package lotto.prize;

import lotto.money.Money;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import static lotto.money.Money.ZERO_VALUE;

public class MatchResult {

    private final Money payment;
    private final Map<LottoPrize, Long> matchResult;

    public MatchResult(Money payment, Map<LottoPrize, Long> matchResult) {
        validate(payment, matchResult);

        this.payment = payment;
        this.matchResult = matchResult;
    }

    private void validate(Money payment, Map<LottoPrize, Long> matchResult) {
        if (Objects.isNull(payment)) {
            throw new IllegalArgumentException("Payment can't be null");
        }

        if (Objects.isNull(matchResult)) {
            throw new IllegalArgumentException("MatchResult can't be null");
        }
    }

    public static MatchResult of(Money payment, Map<LottoPrize, Long> matchResult) {
        return new MatchResult(payment, matchResult);
    }

    public double calculateEarningsRate() {
        Money totalEarnings = Arrays.stream(LottoPrize.values())
                .map(this::calculateEarning)
                .reduce(Money.ZERO, Money::addition);

        return totalEarnings.earningRate(payment);
    }

    private Money calculateEarning(LottoPrize lottoPrize) {
        return lottoPrize.getPrizeMoney()
                .multiply(matchCount(lottoPrize));
    }

    public int matchCount(LottoPrize lottoPrize) {
        if (!matchResult.containsKey(lottoPrize)) {
            return ZERO_VALUE;
        }

        return matchResult.get(lottoPrize)
                .intValue();
    }

}
