package secondplacelotto.model;

public class ProfitCalculator {

    public static float calculate(MatchingNumbers matchingNumbers, int money) {
        int profit = 0;

        for (int i = 0; i < matchingNumbers.getMatchingNumbersCount(); i++) {
            String rank = Integer.toString(i + 1);
            profit = ProfitByRank.getMatchProfit(rank, matchingNumbers.getMatchingCount(rank), profit);
        }

        return profit / (float)money;
    }

}
