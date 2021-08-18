package lottery;

import lottery.domain.*;
import lottery.domain.winningstrategy.MatchAndBonusWinningLotteryStrategy;
import lottery.dto.LotteryStatisticDto;
import lottery.view.*;

public class LotteryGame {

    public static void main(String[] args) {
        Money money = new Money(PurchasingPriceConsoleInput.askPurchasingPrice());
        LotteryQuantity manualQuantity = new LotteryQuantity(ManualLotteryConsoleInput.askLotteryQuantity());
        LotteryOrder lotteryOrder = new LotteryOrder(money, manualQuantity);
        Lotteries lotteries = LotteryMachine.createLotteries(lotteryOrder);
        LotteriesConsoleOutput.printLotteries(manualQuantity.toDto(), lotteries.toDto());
        Lottery winningLottery = new Lottery(WinningLotteryNumberConsoleInput.askWinningLotteryNumbers());
        LotteryNumber bonusNumber = new LotteryNumber(BonusNumberConsoleInput.askBonusBall());
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatistic(new MatchAndBonusWinningLotteryStrategy(winningLottery, bonusNumber));
        LotteryStatisticConsoleOutput.printLotteryStatistic(lotteryStatisticDto);
    }

}
