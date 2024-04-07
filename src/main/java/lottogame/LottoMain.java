package lottogame;

import lottogame.domain.LottoGame;
import lottogame.domain.LottosBundle;
import lottogame.domain.Money;
import lottogame.domain.Number;
import lottogame.domain.WinningLottos;
import lottogame.view.InputView;
import lottogame.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        Money money = InputView.requestMoney();
        ResultView.printLinkBreak();
        LottoGame lottoGame = new LottoGame();
        Number countOfLottos = lottoGame.calculateCountOfLottos(money);
        Number manualCountOfLotto = InputView.requestCountOfManualLottos(countOfLottos);
        ResultView.printLinkBreak();
        LottosBundle lottosBundleOfManual = createLottosBundleOfManual(lottoGame, manualCountOfLotto);
        LottosBundle lottosBundleOfAuto = lottoGame.createLottosBundle(countOfLottos.minus(manualCountOfLotto));

        LottosBundle lottosBundle = lottosBundleOfManual.merge(lottosBundleOfAuto);
        ResultView.printAutoAndManualLottosCount(lottosBundleOfManual, lottosBundleOfAuto);
        ResultView.printLottos(lottosBundle);

        WinningLottos winningLottos = createWinningLottos(lottoGame);

        ResultView.printWinningResult(lottoGame.checkRanks(winningLottos, lottosBundle));
        ResultView.printReturnOfRate(lottoGame.calculateReturnOfRate(winningLottos, lottosBundle));
    }

    private static LottosBundle createLottosBundleOfManual(LottoGame lottoGame, Number manualCountOfLotto) {
        try {
            return lottoGame.createLottosBundle(InputView.requestMultipleManualLottos(manualCountOfLotto));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLottosBundleOfManual(lottoGame, manualCountOfLotto);
        }
    }

    private static WinningLottos createWinningLottos(LottoGame lottoGame) {
        try {
            return lottoGame.createWinningLotto(InputView.requestWinningLotto(), InputView.requestBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLottos(lottoGame);
        }
    }
}
