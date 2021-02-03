package lotto.domain;

import java.util.Map;

public class ROICalculator {

    public static Money getRevenue(Map<Prize, Integer> prizeBoard) {
        int revenue = 0;
        for (Prize prize : prizeBoard.keySet()) {
            revenue += prize.getCash() * prizeBoard.get(prize);
        }
        return Money.of(revenue);
    }

    public static double calculateReturnOnInvestment(Money revenue, Money investMoney) {
        return Math.floor((double) revenue.getMoney() / (double) investMoney.getMoney() * 100) / 100;
    }

}
