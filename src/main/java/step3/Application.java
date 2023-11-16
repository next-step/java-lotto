package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        int inputManualCount = InputView.inputManualLottoCount();
        Lottos inputLottos = InputView.inputManualLottoNumbers();

        Lottos lottos = new LottoMachine().play(inputMoney, inputLottos);
        OutputView.printPurchaseComplete(lottos);

        Lotto winningNumberLotto = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();

        WinningNumbers winningNumbers = WinningNumbers.of(winningNumberLotto, bonusNumber);
        WinningResult result = new ResultProcessor().result(winningNumbers, lottos);

        OutputView.print(result);
    }
}
