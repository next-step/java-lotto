package lottogame;

import lottogame.domain.LottosBundle;
import lottogame.domain.Number;
import lottogame.domain.WinningLottos;
import lottogame.view.InputView;
import lottogame.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        ResultView.printLinkBreak();

        Number countOfLottos = LottosBundle.calculateCountOfLottos(InputView.requestMoney());
        Number manualCountOfLotto = InputView.requestCountOfManualLottos(countOfLottos);
        ResultView.printLinkBreak();

        LottosBundle lottosBundleOfManual = createLottosBundleOfManual(manualCountOfLotto);
        LottosBundle lottosBundleOfAuto = LottosBundle.autoFrom(countOfLottos.minus(manualCountOfLotto));
        LottosBundle lottosBundle = lottosBundleOfManual.merge(lottosBundleOfAuto);
        ResultView.printAutoAndManualLottosCount(lottosBundleOfManual, lottosBundleOfAuto);
        ResultView.printLottos(lottosBundle);

        WinningLottos winningLottos = createWinningLottos();

        ResultView.printWinningResult(lottosBundle.checkRanks(winningLottos));
        ResultView.printReturnOfRate(lottosBundle.calculateReturnOfRate(winningLottos));
    }

    private static WinningLottos createWinningLottos() {
        try {
            return WinningLottos.of(InputView.requestWinningLotto(), InputView.requestBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLottos();
        }
    }

    private static LottosBundle createLottosBundleOfManual(Number manualCountOfLotto) {
        try {
            return LottosBundle.manualFrom(InputView.requestMultipleManualLottos(manualCountOfLotto));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLottosBundleOfManual(manualCountOfLotto);
        }
    }
}
