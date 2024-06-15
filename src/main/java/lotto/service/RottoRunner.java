package lotto.service;

import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class RottoRunner {
    private final LottoSeller seller = new LottoSeller();
    private final LottoResultChecker resultChecker = new LottoResultChecker();

    private final LottoInputView inputView = new LottoInputView();
    private final LottoResultView resultView = new LottoResultView();

    public void run() {
        var money = inputView.inputMoney();
        var lottos = seller.buyLotto(money);
        resultView.printLottos(lottos);

        var winningLotto = inputView.inputWinningLotto();

        var result = resultChecker.checkResult(lottos, winningLotto);
        var rateOfReturn = (double) result.getAllReward() / money;
        resultView.printResult(result, rateOfReturn);
    }
}
