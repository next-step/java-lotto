package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStore {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    public void buy() {
        int lottoAmount = inputView.receivePurchasingAmount();
        Lottos lottos = lottoGenerator.getLottos(lottoAmount);
        resultView.printLottoResult(lottos);

        WinningNumber winningNumber = new WinningNumber(inputView.receiveWinningNumber());
        lottos.calculateLotto(winningNumber);
        resultView.printLottoStatistics(lottos, inputView.getPurchasingAmount());
    }
}
