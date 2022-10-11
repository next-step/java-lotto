package lottery;

import java.util.List;

import static lottery.view.InputView.getLotteryPurchasePrices;
import static lottery.view.InputView.getWinningLotteryNumbers;
import static lottery.view.ResultView.*;

public class Controller {

    public static void main(String[] args) {
        int lotteryPurchasePrices = getLotteryPurchasePrices();

        Customer customer = new Customer();
        customer.purchase(lotteryPurchasePrices);

        printPurchasedLotteryInfos(customer.getLotteryWallet());

        List<Integer> winningLotteryNumbers = getWinningLotteryNumbers();
        LotteryResult lotteryResult = LotteryCompany.createLotteryResult(winningLotteryNumbers, customer.getLotteryWallet());

        printLotteryResult(lotteryResult);
    }

}
