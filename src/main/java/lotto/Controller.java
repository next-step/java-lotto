package lotto;

import java.util.List;

import static lotto.view.InputView.getLotteryPurchasePrices;
import static lotto.view.InputView.getWinningLotteryNumbers;
import static lotto.view.ResultView.*;

public class Controller {

    public static void main(String[] args) {
        int lotteryPurchasePrices = getLotteryPurchasePrices();

        Customer customer = new Customer();
        int purchasedLotteryAmount = customer.purchase(lotteryPurchasePrices);

        printPurchasedLotteryAmount(purchasedLotteryAmount);
        printPurchasedLotteryNumbers(customer.getLottoWallet());

        List<Integer> winningLotteryNumbers = getWinningLotteryNumbers();
        LottoResult lottoResult = LottoCompany.createLottoResult(winningLotteryNumbers, customer.getLottoWallet());

        printLotteryResult(lottoResult);
    }

}
