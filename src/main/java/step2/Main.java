package step2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InputView inputView = InputView.create();
        ResultView resultView = ResultView.create();

        int purchasedPrice = inputView.getPurchasedPrice();

        LottoGame lottoGame = LottoGame.create(purchasedPrice, new Random());
        resultView.printPurchaseCount(lottoGame);
        resultView.printNumber(lottoGame);

        String lastWinningNumber = inputView.getLastLottoNumber();

        lottoGame.countMatchedNumbers(lastWinningNumber);
        resultView.printStatistics(lottoGame);

        double rateOfProfit = lottoGame.calculateRateOfProfit();
        lottoGame.printRateOfProfit(rateOfProfit);
    }
}
