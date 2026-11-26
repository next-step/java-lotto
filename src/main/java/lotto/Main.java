package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        LottoMachine machine = new LottoMachine(inputView.readPurchaseAmount());
        resultView.printLottos(machine.getLottos());

        WinningLotto winningLotto = inputView.readWinningLotto();
        LottoResult result = machine.resultOf(winningLotto);

        resultView.printStatistics(result);
    }
}
