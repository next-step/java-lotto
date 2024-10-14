package step2;

import step2.domain.LottoGenerator;
import step2.domain.Lottos;
import step2.domain.WinningNumber;
import step2.view.InputView;
import step2.view.ResultView;

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
