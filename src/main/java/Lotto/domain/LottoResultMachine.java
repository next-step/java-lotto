package Lotto.domain;

import java.util.Map;

public class LottoResultMachine {

    public static int calcTotalWinningMoney(Map<EqualLottoCntInfo, Integer> totalRankInfo) {
        int totalWinningMoney = 0;
        for (EqualLottoCntInfo equalLottoCntInfo : totalRankInfo.keySet()) {
            totalWinningMoney += equalLottoCntInfo.calcTotalWinningMoney(totalRankInfo.get(equalLottoCntInfo));
        }
        return totalWinningMoney;
    }

    public static double calculateYield(int totalWinningMoney, int buyMoney) {
        return Double.parseDouble(String.format("%.3f", totalWinningMoney / (double)(buyMoney)));
    }
}
