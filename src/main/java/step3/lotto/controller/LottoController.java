package step3.lotto.controller;


import step3.lotto.domain.LottoGame;
import step3.lotto.view.InputLottoView;
import step3.lotto.view.OuterLottoView;

public class LottoController {

    private static LottoGame lottoGame;

    public void gameStart() {
        int purchaseAmount = InputLottoView.inputValue();
        lottoGame = new LottoGame(purchaseAmount);
        lottoGame.buyLotto();

        OuterLottoView.printBuyLotto(lottoGame.getLottoPurchaseCount());
        OuterLottoView.printAutoLottoNumbers(lottoGame.getBuyLottoHashSet(), lottoGame.getLottoPurchaseCount());

        String inputLottoWinnerNumber = InputLottoView.inputWinningLottoNumbers();
        int bonusNumber = InputLottoView.inputBounsNumber();

        lottoGame.getLottoResult(inputLottoWinnerNumber, bonusNumber);

        OuterLottoView.printLottoResult();
        OuterLottoView.printLottoProfitAmount(lottoGame.getlottoProfitAmount());
    }

}
