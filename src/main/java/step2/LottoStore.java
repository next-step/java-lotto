package step2;

import step2.domain.LottoGenerator;
import step2.domain.LottoResult;
import step2.domain.WinningNumber;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoStore {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    public void buy() {
        int lottoAmount = inputView.receivePurchasingAmount();
        LottoResult lottoResult = lottoGenerator.getLottos(lottoAmount);
        resultView.printLottoResult(lottoResult);

        WinningNumber winningNumber = new WinningNumber(inputView.receiveWinningNumber());
        lottoResult.calculateLotto(winningNumber);
        resultView.printLottoStatistics(lottoResult, inputView.getPurchasingAmount());
    }
}
