package lotto.view;

import lotto.domain.ManualLottery;
import lotto.domain.TotalLotteries;

public class Lottery {

    public static void printLotteries(TotalLotteries totalLotteries) {
        System.out.println(totalLotteries.toStringTotalLotteries());
    }

    public static void printManualLotteries(ManualLottery manualLottery) {
        System.out.println(manualLottery.toStringManualLotteries());
    }

    public static void printNumberLotteries(int NumberManualLotteries, int NumberAutoLotteries) {
        System.out.println("수동으로 " + NumberManualLotteries + "장, 자동으로 " + NumberAutoLotteries + "개를 구매했습니다.");
    }

    public static void printWinnerLottery(lotto.domain.Lottery winnerLottery) {
        System.out.println(winnerLottery.toString());
    }
}
