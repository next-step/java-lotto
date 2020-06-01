package step2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MatchReport {

    private static final int DECIMAL_DIGIT = 2;

    private final Money money;
    private final MatchResult matchResult;

    private MatchReport(Money money, MatchResult matchResult) {
        this.money = money;
        this.matchResult = matchResult;
    }

    public static MatchReport create(Money money, MatchResult matchResult) {
        return new MatchReport(money, matchResult);
    }

    public BigDecimal calculateRateOfReturn() {
        return BigDecimal.valueOf(this.matchResult.calculateTotalWinningMoney())
                .divide(BigDecimal.valueOf(money.getUsedAmount()), DECIMAL_DIGIT, RoundingMode.DOWN);
    }
}
