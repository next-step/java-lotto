package secondplacelotto.model;

public class ProfitCalculator {

    public static float calculate(int money) {
        float profit = 0;

        for (int i = 0; i < MatchingNumbers.getMatchingNumbersCount(); i++) {
            profit += ProfitMatcher.getMatchProfit(i, MatchingNumbers.getMatchingCount(i));
        }

        return profit / (float)money;
    }
}
