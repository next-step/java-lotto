package lottery;

import lottery.domain.*;
import lottery.domain.winningstrategy.MatchAndBonusWinningLotteryStrategy;
import lottery.dto.LotteryStatisticDto;
import lottery.view.*;

public class LotteryGame {

    public static void main(String[] args) {
        Money money = new Money(PurchasingPriceConsoleInput.askPurchasingPrice());
        LotteryQuantity manualQuantity = new LotteryQuantity(ManualLotteryConsoleInput.askLotteryQuantity());
        LotteryMachine lotteryMachine = new LotteryMachine(money, manualQuantity);
        Lotteries lotteries = lotteryMachine.createLotteries(ManualLotteryConsoleInput.askLotteries(manualQuantity.getQuantity()));
        LotteriesConsoleOutput.printLotteries(manualQuantity.toDto(), lotteries.toDto());
        Lottery winningLottery = new Lottery(WinningLotteryNumberConsoleInput.askWinningLotteryNumbers());
        LotteryNumber bonusNumber = new LotteryNumber(BonusNumberConsoleInput.askBonusBall());
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatistic(new MatchAndBonusWinningLotteryStrategy(winningLottery, bonusNumber));
        LotteryStatisticConsoleOutput.printLotteryStatistic(lotteryStatisticDto);
    }

}
