package autolotto.model;

public class ProfitCalculator {

    static float profit = 0;

    public static float calculate(int money, LottosComparer lottosComparer) {
        for (int i = 3; i < 7; i++) {
            profit = ProfitMatcher.getMatchProfit(i, lottosComparer.getMatchingCount(i));
        }
        return profit / (float)money;
    }
}
