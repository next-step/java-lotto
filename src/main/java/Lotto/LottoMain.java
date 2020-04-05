package Lotto;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoProgress lottoProgress = new LottoProgress();
        ResultView resultView = new ResultView();

        Amount amount = inputView.inputPurchasingAmount();

        int quantity = lottoProgress.amountToQuantity(amount);
        resultView.showQuantity(quantity);
        LottoBundle lottoBundle = new LottoBundle(quantity);
        resultView.showLottoNumbers(lottoBundle);

        List<Integer> prizeList = inputView.inputPrizeNumber();

        int[] winnerArray = lottoProgress.matchNumber(lottoBundle, prizeList);
        resultView.showWinner(winnerArray, amount);
    }


}
