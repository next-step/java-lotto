package lottery;

import static lottery.LotteryCompany.createLotteryResult;
import static lottery.view.InputView.*;
import static lottery.view.ResultView.*;

public class Controller {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.purchase(getLotteryPurchasePrices());

        printPurchasedLotteryInfos(customer.getLotteryWallet());

        LotteryResult lotteryResult = createLotteryResult(getWinningLotteryNumbers(), customer.getLotteryWallet());

        printLotteryResult(lotteryResult);
    }

}
