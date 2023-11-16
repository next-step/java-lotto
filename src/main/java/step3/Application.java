package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        Optional<Integer> inputMoney = InputView.inputMoney();

        inputMoney.ifPresent((money)->{
            Optional<Integer> inputManualCount = InputView.inputManualLottoCount();

            inputManualCount.ifPresent((manualCount)->{
                Optional<Lottos> inputLottos = InputView.inputManualLottoNumbers(manualCount);

                inputLottos.ifPresent((manualLottos)->{
                    Lottos lottos = new LottoMachine().play(money, manualLottos);
                    OutputView.printPurchaseComplete(lottos);

                    Lotto winningNumberLotto = InputView.inputWinningNumbers();
                    LottoNumber bonusNumber = InputView.inputBonusNumber();

                    WinningNumbers winningNumbers = WinningNumbers.of(winningNumberLotto, bonusNumber);
                    WinningResult result = new ResultProcessor().result(winningNumbers, lottos);

                    OutputView.print(result);
                });
            });
        });


    }
}
