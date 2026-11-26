package lotto.application;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        LottoMachine machine = new LottoMachine(inputView.readPurchaseAmount());
        resultView.printLottos(machine.getLottos());

        WinningLotto winningLotto = inputView.readWinningLotto();
        LottoResult result = machine.resultOf(winningLotto);

        resultView.printStatistics(result);
    }
}
