package lottogame;

import java.util.List;
import lottogame.domain.LottoGame;
import lottogame.domain.LottosBundle;
import lottogame.domain.Money;
import lottogame.domain.Number;
import lottogame.domain.Numbers;
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
            List<Numbers> manualInputNumbers = InputView.requestMultipleManualLottos(manualCountOfLotto);
            LottosBundle lottosBundleOfManual = lottoGame.createLottosBundle(manualInputNumbers);
            return lottosBundleOfManual;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLottosBundleOfManual(lottoGame, manualCountOfLotto);
        }
    }

    private static WinningLottos createWinningLottos(LottoGame lottoGame) {
        try {
            Numbers winningLottosNumbers = InputView.requestWinningLotto();
            Number bonusNumber = InputView.requestBonusNumber();
            return lottoGame.createWinningLotto(winningLottosNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLottos(lottoGame);
        }
    }
}
