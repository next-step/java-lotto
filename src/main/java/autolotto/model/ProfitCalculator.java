package autolotto.model;

public class ProfitCalculator {

    static float profit = 0;

    public static float calculate(int money, MatchingNumbers matchingNumbers) {
        for (int i = 3; i < 7; i++) {
            profit = ProfitMatcher.getMatchProfit(i, matchingNumbers.getMatchingCount(i));
        }
        return profit / (float)money;
    }
}
