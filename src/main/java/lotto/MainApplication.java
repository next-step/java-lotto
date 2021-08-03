package lotto;

import lotto.application.PlayLotto;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        int cash = InputView.inputCash();
        int lottoCount = PlayLotto.calculateLottoCount(cash);
        ResultView.printLottoCount(lottoCount);
        List<Lotto> lottos = PlayLotto.createLotto(lottoCount);
        ResultView.printLottos(lottos);
        String winningNumberString = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();
        int[] winningArray = PlayLotto.playLotto(winningNumberString, bonusNumber, lottos);
        double profitRate = PlayLotto.calculateProfitRate(cash,winningArray);
        ResultView.printResultSubject();
        ResultView.printPrizeResult(winningArray);
        ResultView.printProfitRate(profitRate);
    }
}
