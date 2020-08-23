package controller;


import domain.LottoGame;
import domain.LottoResults;
import domain.Lottos;
import domain.WinningLotto;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int buyPrice = InputView.inputBuyPrice();
        int passivityCount = InputView.inputManualCount();

        LottoGame lottoGame = LottoGame.of(buyPrice, passivityCount);
        List<String> passivityLottos = InputView.inputPassivityCountLottos(passivityCount);

        ResultView.viewBuyAmount(lottoGame);
        Lottos lottos = lottoGame.issue(passivityLottos);
        ResultView.viewIssuedLotto(lottos);

        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumber(), InputView.inputBonusNumber());
        LottoResults result = lottos.getLottoResult(winningLotto);

        ResultView.viewPrize(result);
        ResultView.viewWinningRate(buyPrice, result);
    }
}
