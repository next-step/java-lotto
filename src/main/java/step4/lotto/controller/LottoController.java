package step4.lotto.controller;


import step4.lotto.domain.LottoGame;
import step4.lotto.view.InputLottoView;
import step4.lotto.view.OuterLottoView;

import java.util.List;

public class LottoController {

    public void gameStart() {
        LottoGame lottoGame;
        List<String> manualLottoNumber = null;

        int purchaseAmount = InputLottoView.inputPrice();
        int manualLottoBuyCount = InputLottoView.inputManualLottoBuyCount();

        if (manualLottoBuyCount > 0) {
            manualLottoNumber = InputLottoView.InputManualNumber(manualLottoBuyCount);
        }

        lottoGame = new LottoGame(purchaseAmount, manualLottoBuyCount);
        buyLotto(lottoGame, manualLottoNumber);
        outterLottoNumber(lottoGame);

        String inputLottoWinnerNumber = InputLottoView.inputWinningLottoNumbers();
        int bonusNumber = InputLottoView.inputBounsNumber();

        lottoGame.getLottoResult(inputLottoWinnerNumber, bonusNumber);
        printLottoResultView(lottoGame);
    }

    private void buyLotto(LottoGame lottoGame, List<String> manualLottoNumber) {
        lottoGame.buyManualLotto(manualLottoNumber);
        lottoGame.buyAutoLotto();
    }

    private void outterLottoNumber(LottoGame lottoGame) {
        OuterLottoView.printLottoHowToKinds(lottoGame.getLottoManualBuyCount(), lottoGame.getLottoAutoBuyCount());
        OuterLottoView.printAutoLottoNumbers(lottoGame.getBuyLottoHashSet());
    }

    private void printLottoResultView(LottoGame lottoGame) {
        OuterLottoView.printLottoResult();
        OuterLottoView.printLottoProfitAmount(lottoGame.getLottoProfitAmount());
    }
}
