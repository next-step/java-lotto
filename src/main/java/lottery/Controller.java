package lottery;

import java.util.List;

import static lottery.LotteryCompany.getAvailablePurchaseLotteryCount;
import static lottery.view.InputView.*;
import static lottery.view.ResultView.*;

public class Controller {

    public static void main(String[] args) {
        Customer customer = new Customer();

        int availablePurchaseLotteryCount = getAvailablePurchaseLotteryCount(getLotteryPurchasePrices());
        for (int i = 0; i < availablePurchaseLotteryCount; i++) {
            customer.purchaseRandomLottery();
        }

        List<Lottery> lotteries = customer.getLotteries();
        printPurchasedLotteryInfos(lotteries);

        WinningLottery winningLottery = new WinningLottery(getWinningLotteryNumbers(), getBonusLotteryNumber());
        LotteryResult lotteryResult = winningLottery.createLotteryResult(lotteries);
        printLotteryResult(lotteryResult);
    }

}
