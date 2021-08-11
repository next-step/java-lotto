package lotto.domain;

public class WinningStatisticsResolver {
    public double resolve(int compensation, int purchaseAmount) {
        return Double.parseDouble(String.format("%.2f", (double) compensation / purchaseAmount));
    }
}
