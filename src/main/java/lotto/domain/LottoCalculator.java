package lotto.domain;

public class LottoCalculator {

    public static String revenueCalculate(int inputMoney, int totalMatchMoney) {
        double revenueRate = Double.valueOf(totalMatchMoney) / Double.valueOf(inputMoney);
        return String.format("%.2f", revenueRate);
    }
}
