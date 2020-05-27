package lotto.domain.lotto;

public class LottoRevenueCalculator {

    private LottoRevenueCalculator() {

    }

    public static String revenueCalculate(int inputMoney, int totalMatchMoney) {
        double revenueRate = Double.valueOf(totalMatchMoney) / Double.valueOf(inputMoney);
        return String.format("%.2f", revenueRate);
    }
}
