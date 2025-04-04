package lotto;

public class LottoResult {

    public static double calculateProfitRate(int purchaseAmount, int winningAmount) {
        return (double) winningAmount / purchaseAmount;
    }
}
