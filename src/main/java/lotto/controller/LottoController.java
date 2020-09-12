package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<String> manualLottos = InputView.inputManualLotto();

        LottoGame lottoGame = LottoGame.of(purchaseAmount, manualLottos.size());
        ResultView.printPurchaseLottoCount(lottoGame.getCount(), manualLottos.size());

        Lottos lottos = lottoGame.makeLottos(manualLottos);
        ResultView.printLottos(lottos.toStringByLotto());

        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumberOfLastWeek(), InputView.inputBonusNumber());
        LottoResult lottoResult = lottos.match(winningLotto);

        ResultView.printResultLottoGame(lottoResult);
    }
}
