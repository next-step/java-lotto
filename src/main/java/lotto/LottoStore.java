package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoStore {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    public void buy() {
        int lottoAmount = inputView.receivePurchasingAmount();
        Lottos lottos = lottoGenerator.getLottos(lottoAmount);
        resultView.printLottoResult(lottos);

        List<LottoNumber> winningNumber = inputView.receiveWinningNumber();
        LottoNumber bonusNumber = inputView.receiveBonusNo();

        lottos.calculateLotto(new WinningNumber(winningNumber, bonusNumber));
        resultView.printLottoStatistics(lottos, inputView.getPurchasingAmount());
    }
}
