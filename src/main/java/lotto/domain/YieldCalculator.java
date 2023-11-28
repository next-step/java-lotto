package lotto.domain;

public class YieldCalculator {
    public static double calculate(long cost, RankResult rankResult) {
        long sum = rankResult.calculateTotalPrizeMoney();
        double yield = calculateYield(cost, (double) sum);
        return createFormattedYield(yield);
    }

    private static double calculateYield(long cost, double sum) {
        return sum / cost;
    }

    private static double createFormattedYield(double yield) {
        return Math.floor(yield * 100.0) / 100.0;
    }
}
