package lottery;

import lottery.domain.*;
import lottery.domain.winningstrategy.MatchWinningLotteryStrategy;
import lottery.dto.LotteryStatisticDto;
import lottery.view.LotteriesConsoleOutput;
import lottery.view.LotteryStatisticConsoleOutput;
import lottery.view.PurchasingPriceConsoleInput;
import lottery.view.WinningLotteryNumberConsoleInput;

public class LotteryGame {

    public static void main(String[] args) {
        Money money = new Money(PurchasingPriceConsoleInput.askPurchasingPrice());
        Lotteries lotteries = LotteryFactory.getLotteries(money);
        LotteriesConsoleOutput.printLotteries(lotteries.getLotteriesDto());
        Lottery winningLottery = LotteryFactory.getLottery(WinningLotteryNumberConsoleInput.askWinningLotteryNumbers());
        LotteryStatisticDto lotteryStatisticDto = lotteries.getLotteryStatisticDto(new MatchWinningLotteryStrategy(winningLottery));
        LotteryStatisticConsoleOutput.printLotteryStatistic(lotteryStatisticDto);
    }

}
