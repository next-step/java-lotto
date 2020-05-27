package lotto.domain.rank;

public class LottoRevenueCalculator {

    private LottoRevenueCalculator() {

    }

    private static String revenueCalculate(int inputMoney, int totalMatchMoney) {
        double revenueRate = Double.valueOf(totalMatchMoney) / Double.valueOf(inputMoney);
        return String.format("%.2f", revenueRate);
    }

}
