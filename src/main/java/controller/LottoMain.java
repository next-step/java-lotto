package controller;


import domain.LottoGame;
import domain.LottoResults;
import domain.Lottos;
import strategy.RandomLottoNumberGenerator;
import view.InputView;
import view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int buyPrice = InputView.inputBuyPrice();
        int manualCount = InputView.inputManualCount();

        LottoGame lottoGame = LottoGame.of(buyPrice);

        ResultView.viewBuyAmount(lottoGame.getBuyAmount());
        Lottos lottos = lottoGame.issue(new RandomLottoNumberGenerator());
        ResultView.viewIssuedLotto(lottos);

        LottoResults prizes = lottos.getLottoResult(InputView.inputWinningNumber(), InputView.inputBonusNumber());

        ResultView.viewPrize(prizes);
        ResultView.viewWinningRate(buyPrice, prizes);
    }
}
