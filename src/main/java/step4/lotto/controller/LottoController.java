package step4.lotto.controller;


import step4.lotto.domain.LottoGame;
import step4.lotto.view.InputLottoView;
import step4.lotto.view.OuterLottoView;

public class LottoController {

    public void gameStart() {
        LottoGame lottoGame;
        int purchaseAmount = InputLottoView.inputValue();
        lottoGame = new LottoGame(purchaseAmount);
        lottoGame.buyLotto();

        OuterLottoView.printBuyLotto(lottoGame.getLottoPurchaseCount());
        OuterLottoView.printAutoLottoNumbers(lottoGame.getBuyLottoHashSet());

        String inputLottoWinnerNumber = InputLottoView.inputWinningLottoNumbers();
        int bonusNumber = InputLottoView.inputBounsNumber();

        lottoGame.getLottoResult(inputLottoWinnerNumber, bonusNumber);

        OuterLottoView.printLottoResult();
        OuterLottoView.printLottoProfitAmount(lottoGame.getLottoProfitAmount());
    }

}
