package lottery;

import java.util.List;

import static lottery.view.InputView.getLotteryPurchasePrices;
import static lottery.view.InputView.getWinningLotteryNumbers;
import static lottery.view.ResultView.*;

public class Controller {

    public static void main(String[] args) {
        int lotteryPurchasePrices = getLotteryPurchasePrices();

        Customer customer = new Customer();
        int purchasedLotteryAmount = customer.purchase(lotteryPurchasePrices);

        printPurchasedLotteryAmount(purchasedLotteryAmount);
        printPurchasedLotteryNumbers(customer.getLotteryWallet());

        List<Integer> winningLotteryNumbers = getWinningLotteryNumbers();
        LotteryResult lotteryResult = LotteryCompany.createLotteryResult(winningLotteryNumbers, customer.getLotteryWallet());

        printLotteryResult(lotteryResult);
    }

}
