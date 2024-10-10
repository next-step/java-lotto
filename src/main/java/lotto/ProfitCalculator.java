package lotto;

import java.util.List;

public class ProfitCalculator {

    public static int calculateTotalProfit(List<Integer> equalNumberCountList) {
        return equalNumberCountList.stream()
                .mapToInt(LottoRank::findPrizeMoneyFromEqualNumberCount)
                .sum();
    }
}
