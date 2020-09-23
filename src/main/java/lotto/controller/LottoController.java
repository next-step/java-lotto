package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<String> manualLottos = InputView.inputManualLotto();

        LottoGame lottoGame = LottoGame.of(purchaseAmount, manualLottos.size(), manualLottos);
        ResultView.printPurchaseLottoCount(manualLottos.size(), lottoGame.getCount());

        Lottos lottos = lottoGame.getLottos();
        ResultView.printLottos(lottos.toStringByLotto());

        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumberOfLastWeek(), InputView.inputBonusNumber());
        LottoResult lottoResult = lottoGame.getLottoResult(winningLotto);

        ResultView.printResultLottoGame(lottoResult);
    }
}
