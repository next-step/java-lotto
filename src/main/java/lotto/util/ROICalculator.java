package lotto.util;

import java.util.Map;
import lotto.domain.Prize;

public class ROICalculator {

    private ROICalculator() {
    }

    public static int getRevenue(Map<Prize, Integer> prizeBoard) {
        int revenue = 0;
        for (Prize prize : prizeBoard.keySet()) {
            revenue += prize.getCash() * prizeBoard.get(prize);
        }
        return revenue;
    }

    public static double calculateReturnOnInvestment(int revenue, int investMoney) {
        return Math.floor((double) revenue / (double) investMoney * 100) / 100;
    }
}
