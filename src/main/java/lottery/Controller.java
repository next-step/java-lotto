package lottery;

import java.util.List;

import static lottery.LotteryCompany.getAvailablePurchaseCount;
import static lottery.view.InputView.*;
import static lottery.view.ResultView.printPurchasedLotteryInfos;
import static lottery.view.ResultView.printResult;

public class Controller {

    public static void main(String[] args) {
        Customer customer = new Customer();

        int availablePurchaseLotteryCount = getAvailablePurchaseCount(getLotteryPurchasePrices());
        for (int i = 0; i < availablePurchaseLotteryCount; i++) {
            customer.purchaseRandomLottery();
        }

        List<Lottery> lotteries = customer.getLotteries();
        printPurchasedLotteryInfos(lotteries);

        WinningLottery winningLottery = getWinningLottery();
        LotteryResult lotteryResult = winningLottery.createLotteryResult(lotteries);
        printResult(lotteryResult);
    }

}
