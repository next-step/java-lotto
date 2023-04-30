package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        Money lottoAmount = InputView.inputPrice();

        Amount manualAmount = InputView.inputManualAmount();
        Amount autoAmount = manualAmount.calculateAutoLottos(lottoAmount);

        Lottos manualLottos = InputView.inputManualLottos(manualAmount);
        OutputView.printLottoQuantity(manualAmount, autoAmount);

        Lottos wholeLottos = manualLottos.createAutoLottos(autoAmount);
        OutputView.printLottos(wholeLottos);

        Lotto previousWinningLotto = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.init(previousWinningLotto, bonusNumber);

        Winners winners = wholeLottos.findStatistics(winningLotto);
        OutputView.printResult(winners, lottoAmount);
    }
}
