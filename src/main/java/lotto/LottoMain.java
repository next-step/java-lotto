package lotto;

import lotto.domain.LottoGame;
import lotto.domain.ManualLottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int totalCount = InputView.inputPrice();
        ManualLottos manualLottos = InputView.inputManualLottos();
        LottoGame lottoGame = new LottoGame(totalCount, manualLottos);
        ResultView.printLottoNumbers(lottoGame);

        WinningLotto winningLotto = InputView.inputWinningNumber();
        ResultView.printLottoGameResult(lottoGame.draw(winningLotto));
    }
}
