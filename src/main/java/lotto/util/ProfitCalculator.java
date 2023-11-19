package lotto.util;

public class ProfitCalculator {

    public static double calculateProfitRate(int investmentAmount, long profit) {
        return Math.ceil(profit * 100 / investmentAmount) / 100;
    }

}
