package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        Money lottoAmount = InputView.inputPrice();
        OutputView.printLottoQuantity(lottoAmount);

        Lottos lottos = Lottos.init(lottoAmount);
        OutputView.printLottos(lottos);

        Lotto previousWinningLotto = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.init(previousWinningLotto, bonusNumber);

        Winners winners = lottos.findStatistics(winningLotto);
        OutputView.printResult(winners, lottoAmount);
    }
}
