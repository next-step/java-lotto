package controller;


import domain.LottoGame;
import domain.LottoResults;
import domain.Lottos;
import strategy.RandomLottoNumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int buyPrice = InputView.inputBuyPrice();
        int passivityCount = InputView.inputManualCount();

        LottoGame lottoGame = LottoGame.of(buyPrice, passivityCount);
        List<String> passivityLottos = InputView.inputPassivityCountLottos(passivityCount);

        ResultView.viewBuyAmount(lottoGame.getAutoCount());
        Lottos lottos = lottoGame.issue(new RandomLottoNumberGenerator());
        ResultView.viewIssuedLotto(lottos);

        LottoResults prizes = lottos.getLottoResult(InputView.inputWinningNumber(), InputView.inputBonusNumber());

        ResultView.viewPrize(prizes);
        ResultView.viewWinningRate(buyPrice, prizes);
    }
}
