package lottery;

import lottery.domain.*;
import lottery.domain.winningstrategy.MatchAndBonusWinningLotteryStrategy;
import lottery.dto.LotteryStatisticDto;
import lottery.view.*;

public class LotteryGame {

    public static void main(String[] args) {
        Money money = new Money(PurchasingPriceConsoleInput.askPurchasingPrice());
        Lotteries lotteries = LotteryFactory.getLotteries(money);
        LotteriesConsoleOutput.printLotteries(lotteries.getLotteriesDto());
        Lottery winningLottery = new Lottery(WinningLotteryNumberConsoleInput.askWinningLotteryNumbers());
        LotteryNumber bonusNumber = new LotteryNumber(BonusNumberConsoleInput.askBonusBall());
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatisticDto(new MatchAndBonusWinningLotteryStrategy(winningLottery, bonusNumber));
        LotteryStatisticConsoleOutput.printLotteryStatistic(lotteryStatisticDto);
    }

}
