package lottery;

import lottery.domain.Lotteries;
import lottery.domain.WinLottery;
import lottery.service.LotteryDrawer;
import lottery.view.InputView;
import lottery.view.ResultView;

public class LotteryApplication {

    public static void main(String[] args){
        int moneyAmount = InputView.moneyAmount();
        Lotteries lotteries = new Lotteries(moneyAmount);
        ResultView.purchasedLotteryResult(lotteries);

        String winPrizeNumbersString = InputView.winPrizeNumbersString();
        WinLottery winLottery = new WinLottery(winPrizeNumbersString);

        LotteryDrawer lotteryDrawer = new LotteryDrawer(lotteries, winLottery);

        ResultView.winStatistics(lotteryDrawer.winStatistics());
        ResultView.profitRate(lotteryDrawer.profitRate());
    }
}
