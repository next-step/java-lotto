package Lotto;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoInGame lottoGame = new LottoInGame();
        ResultView resultView = new ResultView();

        Amount amount = inputView.inputPurchasingAmount();

        int quantity = lottoGame.translateAmountToQuantity(amount);
        resultView.showQuantity(quantity);
        LottoBundle lottoPapers = new LottoBundle(quantity);
        resultView.showLottoNumbers(lottoPapers);

        List<Integer> prizeNumber = inputView.inputPrizeNumber();
        int bonusNumber = inputView.inputBonusNumber();

        PrizeNumbers prizeNumbers = new PrizeNumbers(prizeNumber, bonusNumber);

        List<Rank> winners = lottoGame.matchNumber(lottoPapers, prizeNumbers);

        resultView.showWinner(winners, amount);
    }


}
