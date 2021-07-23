package lotto.prize;

import java.util.Map;
import java.util.Objects;

public class MatchResult {

    private final int payment;
    private final Map<LottoPrize, Integer> matchResult;

    public MatchResult(int payment, Map<LottoPrize, Integer> matchResult) {
        validate(payment, matchResult);
        this.payment = payment;
        this.matchResult = matchResult;
    }

    private void validate(int payment, Map<LottoPrize, Integer> matchResult) {
        if (payment < 0) {
            throw new IllegalArgumentException("Payment can't be under zero");
        }
        if (Objects.isNull(matchResult)) {
            throw new IllegalArgumentException("MatchResult can't be null");
        }
    }

    public static MatchResult init(int payment, Map<LottoPrize, Integer> matchResult) {
        return new MatchResult(payment, matchResult);
    }
}
