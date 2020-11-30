package step4.lotto.controller;


import step4.lotto.domain.LottoGame;
import step4.lotto.view.InputLottoView;
import step4.lotto.view.PrintResultLottoView;

import java.util.List;

public class LottoController {

    public void gameStart() {
        List<String> manualLottoNumber = null;

        int purchaseAmount = InputLottoView.inputPrice();
        int manualLottoBuyCount = InputLottoView.inputManualLottoBuyCount();

        if (manualLottoBuyCount > 0) {
            manualLottoNumber = InputLottoView.InputManualNumber(manualLottoBuyCount);
        }

        LottoGame lottoGame = new LottoGame(purchaseAmount, manualLottoBuyCount);
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
        PrintResultLottoView.printLottoHowToKinds( lottoGame.getLottoTicketCount().getLottoManualBuyCount(), lottoGame.getLottoTicketCount().getLottoAutoBuyCount());
        PrintResultLottoView.printAutoLottoNumbers(lottoGame.getBuyLottoHashSet());
    }

    private void printLottoResultView(LottoGame lottoGame) {
        PrintResultLottoView.printLottoResult();
        PrintResultLottoView.printLottoProfitAmount(lottoGame.getLottoTicketCount().getLottoPurchaseAmount());
    }
}
