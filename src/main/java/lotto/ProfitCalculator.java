package lotto;

import java.util.List;

public class ProfitCalculator {
    public static float calculateProfitRate(int totalPurchaseAmount, List<Integer> equalNumberCountList) {
        int totalProfitAmount = calculateTotalProfit(equalNumberCountList);

        float profitRate = ((float) totalProfitAmount / totalPurchaseAmount) * 100;
        return Math.round(profitRate * 100) / 100.0f;
    }

    public static int calculateTotalProfit(List<Integer> equalNumberCountList) {
        return equalNumberCountList.stream()
                .mapToInt(LottoRank::findPrizeMoneyFromEqualNumberCount)
                .sum();
    }
}
