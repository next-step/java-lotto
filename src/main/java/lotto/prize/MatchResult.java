package lotto.prize;

import java.util.Map;

public class MatchResult {

    private final int payment;
    private final Map<LottoPrize, Integer> matchResult;

    public MatchResult(int payment, Map<LottoPrize, Integer> matchResult) {
        this.payment = payment;
        this.matchResult = matchResult;
    }

    public static MatchResult init(int payment, Map<LottoPrize, Integer> matchResult) {
        return new MatchResult(payment, matchResult);
    }
}
