package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        Money lottoAmount = InputView.inputPrice();
        OutputView.printLottoQuantity(lottoAmount);

        Lottos lottos = Lottos.initLottos(lottoAmount);
        OutputView.printLottos(lottos);

        Lotto winningLotto = InputView.inputWinningNumbers();
        Winners winners = lottos.findStatistics(winningLotto);
        OutputView.printResult(winners, lottoAmount);
    }
}
