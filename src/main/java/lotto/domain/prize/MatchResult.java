package lotto.domain.prize;

import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class MatchResult {
    private static final int NO_MATCH_COUNT = 0;
    private final Map<LottoPrize, Long> matchResult;
    private final Money money;

    public MatchResult(Map<LottoPrize, Long> matchResult, Money money) {
        validate(matchResult, money);
        this.matchResult = matchResult;
        this.money = money;
    }

    private void validate(Map<LottoPrize, Long> matchResult, Money money) {
        if (Objects.isNull(matchResult)) {
            throw new IllegalArgumentException("matchResult는 null이면 안됩니다");
        }

        if (Objects.isNull(money)) {
            throw new IllegalArgumentException("Money는 값이 있어야합니다");
        }
    }

    public static MatchResult of(Map<LottoPrize, Long> matchResult, Money money) {
        return new MatchResult(matchResult, money);
    }

    public Map<LottoPrize, Long> getMatchResult() {
        return matchResult;
    }

    public int matchCount(LottoPrize lottoPrize) {
        if (isNotContainsKey(lottoPrize)) {
            return NO_MATCH_COUNT;
        }

        return matchResult.get(lottoPrize)
                .intValue();
    }

    public double calculateEarningsRate() {
        return getTotalEarnings().earningRate(money);
    }

    private Money getTotalEarnings() {
        return Arrays.stream(LottoPrize.values())
                .map(this::calculateEarning)
                .reduce(Money.MIN, Money::addition);
    }

    private Money calculateEarning(LottoPrize lottoPrize) {
        return lottoPrize.getPrizeMoney().multiply(matchCount(lottoPrize));
    }

    private boolean isNotContainsKey(LottoPrize lottoPrize) {
        return !matchResult.containsKey(lottoPrize);
    }
}
