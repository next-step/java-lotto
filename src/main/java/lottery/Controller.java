package lottery;

import java.util.List;

import static lottery.LotteryCompany.getAvailablePurchaseAmount;
import static lottery.view.InputView.*;
import static lottery.view.ResultView.printPurchasedLotteryInfos;
import static lottery.view.ResultView.printResult;

public class Controller {

    public static void main(String[] args) {
        Customer customer = new Customer();

        int availablePurchaseLotteryAmount = getAvailablePurchaseAmount(getLotteryPurchasePrices());
        List<Lottery> manualLotteries = getManualLotteries(getManualLotteryPurchaseAmount());
        customer.purchaseLotteries(availablePurchaseLotteryAmount, manualLotteries);

        List<Lottery> lotteries = customer.getLotteries();
        printPurchasedLotteryInfos(lotteries, manualLotteries.size());

        WinningLottery winningLottery = getWinningLottery();
        printResult(winningLottery.createLotteryResult(lotteries));
    }

}
