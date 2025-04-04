package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoInput lottoInput = InputView.lottoInput();
        Lottos lottos = ResultView.printAndGetLottos(lottoInput, InputView.inputManualLotto(lottoInput.getManualCount()));

        String winningNumber = InputView.inputWinningNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        ResultView.printResultOverview();

        Rewards result = lottos.getResult(winningNumbers, bonusNumber);
        ResultView.printResult(lottoInput.getInitialAmount(), result);
    }
}
