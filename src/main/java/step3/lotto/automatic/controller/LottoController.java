package step3.lotto.automatic.controller;


import step3.lotto.automatic.domain.LottoGame;
import step3.lotto.automatic.view.InputLottoView;
import step3.lotto.automatic.view.OuterLottoView;

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
