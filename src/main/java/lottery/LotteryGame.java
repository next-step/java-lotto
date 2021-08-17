package lottery;

import lottery.domain.*;
import lottery.domain.createstrategy.ManualCreatingLotteryStrategy;
import lottery.domain.createstrategy.RandomCreatingLotteryStrategy;
import lottery.domain.winningstrategy.MatchAndBonusWinningLotteryStrategy;
import lottery.dto.LotteryStatisticDto;
import lottery.view.*;

public class LotteryGame {

    public static void main(String[] args) {
        LotteryMachine lotteryMachine = new LotteryMachine(new Money(PurchasingPriceConsoleInput.askPurchasingPrice()));
        LotteryQuantity quantity = new LotteryQuantity(ManualLotteryConsoleInput.askLotteryQuantity());
        Lotteries lotteries = new Lotteries(
                lotteryMachine.createLotteries(new ManualCreatingLotteryStrategy(ManualLotteryConsoleInput.askLotteries(lotteryMachine.validateQuantityAndGet(quantity)))),
                lotteryMachine.createLotteries(new RandomCreatingLotteryStrategy()));
        LotteriesConsoleOutput.printLotteries(quantity.toDto(), lotteries.getLotteriesDto());
        Lottery winningLottery = new Lottery(WinningLotteryNumberConsoleInput.askWinningLotteryNumbers());
        LotteryNumber bonusNumber = new LotteryNumber(BonusNumberConsoleInput.askBonusBall());
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatisticDto(new MatchAndBonusWinningLotteryStrategy(winningLottery, bonusNumber));
        LotteryStatisticConsoleOutput.printLotteryStatistic(lotteryStatisticDto);
    }

}
