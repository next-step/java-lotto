package lotto.prize;

import lotto.money.Money;

import java.util.Map;
import java.util.Objects;

public class MatchResult {

    private final Money payment;
    private final Map<LottoPrize, Integer> matchResult;

    public MatchResult(Money payment, Map<LottoPrize, Integer> matchResult) {
        validate(payment, matchResult);
        this.payment = payment;
        this.matchResult = matchResult;
    }

    private void validate(Money payment, Map<LottoPrize, Integer> matchResult) {
        if (Objects.isNull(payment)) {
            throw new IllegalArgumentException("Payment can't be null");
        }
        if (Objects.isNull(matchResult)) {
            throw new IllegalArgumentException("MatchResult can't be null");
        }
    }

    public static MatchResult init(int payment, Map<LottoPrize, Integer> matchResult) {
        return new MatchResult(Money.init(payment), matchResult);
    }

    public static MatchResult init(Money payment, Map<LottoPrize, Integer> matchResult) {
        return new MatchResult(payment, matchResult);
    }
}
