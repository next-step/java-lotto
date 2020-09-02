package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LottoGame lottoGame = LottoGame.of(purchaseAmount);
        ResultView.printPurchaseLottoCount(lottoGame.getCount());

        Lottos lottos = lottoGame.makeLottos(new LottoNumberRandomGenerator());
        ResultView.printLottos(lottos.toStringByLotto());

        WinningLotto winningLotto = InputView.inputWinningNumberOfLastWeek();
        LottoResult lottoResult = lottos.match(winningLotto);

        ResultView.printResultLottoGame(lottoResult);
    }
}
