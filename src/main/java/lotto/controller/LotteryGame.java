package lotto.controller;

import lotto.domain.*;

import java.util.Arrays;

import static lotto.domain.LotteryNo.makeLotteryNos;
import static lotto.view.Lottery.*;
import static lotto.view.ProfitRate.printStatistics;

public class LotteryGame {

    public static void main() {
        System.out.println("구입 금액을 입력해 주세요.");
        String inputMoney = "30000";
        System.out.println(inputMoney);
        TotalLotteries totalLotteries = new TotalLotteries(inputMoney);

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int ManualLotteriesCount = 3;
        System.out.println(ManualLotteriesCount);

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        final Lottery firstManualLottery = new Lottery(makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 6)));
        final Lottery secondManualLottery = new Lottery(makeLotteryNos(Arrays.asList(11, 15, 24, 31, 33, 8)));
        final Lottery thirdManualLottery = new Lottery(makeLotteryNos(Arrays.asList(24, 27, 30, 40, 44, 10)));

        Lotteries lotteries = new Lotteries();
        lotteries.addLottery(firstManualLottery)
                .addLottery(secondManualLottery)
                .addLottery(thirdManualLottery);

        ManualLottery manualLottery = new ManualLottery(ManualLotteriesCount);
        manualLottery.generateManualLotteries(lotteries);
        printManualLotteries(manualLottery);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Lottery winnerNumber = new Lottery(makeLotteryNos(Arrays.asList(24, 30, 22, 23, 26, 6)));
        printWinnerLottery(winnerNumber);

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = 7;
        System.out.println(bonusNumber);

        WinnerLottery winnerLottery = new WinnerLottery(winnerNumber, bonusNumber);
        AutoLotteries autoLotteries = new AutoLotteries(totalLotteries.countPurchaseQuantity(), ManualLotteriesCount);

        totalLotteries.generateLotteries(manualLottery.generateManualLotteries(lotteries), autoLotteries.generateAutoLotteries());

        printNumberLotteries(manualLottery.getManualLotteriesSize(), autoLotteries.getAutoLotteriesSize());
        printLotteries(totalLotteries);
        printStatistics(totalLotteries, winnerLottery);
    }
}
