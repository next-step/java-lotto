package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumberRandomGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LottoGame lottoGame = LottoGame.of(purchaseAmount);
        ResultView.printPurchaseLottoCount(lottoGame.getCount());

        Lottos lottos = lottoGame.makeLottos(new LottoNumberRandomGenerator());
        ResultView.printLottos(lottos.toStringByLotto());

        List<Integer> winningNumbers = InputView.inputWinningNumberOfLastWeek();
        LottoResult lottoResult = lottos.match(winningNumbers);

        ResultView.printResultLottoGame(lottoResult);
        ResultView.printRateOfLottoGame(lottoResult.rateOfTotalPrize(purchaseAmount));
    }
}
