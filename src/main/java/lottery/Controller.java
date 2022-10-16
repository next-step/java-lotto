package lottery;

import static lottery.LotteryCompany.createLotteryResult;
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

        printPurchasedLotteryInfos(customer.getLotteryWallet());
        LotteryResult lotteryResult = createLotteryResult(getWinningLotteryNumbers(), customer.getLotteryWallet());
        printLotteryResult(lotteryResult);
    }

}
