package lotto.service;

import lotto.view.LottoInputProcessor;
import lotto.view.LottoViewer;

public class RottoRunner {
    private final LottoSeller seller = new LottoSeller();
    private final LottoResultChecker resultChecker = new LottoResultChecker();

    private final LottoViewer viewer = new LottoViewer();
    private final LottoInputProcessor inputProcessor = new LottoInputProcessor(viewer);

    public void run() {
        var money = inputProcessor.inputMoney();
        var lottos = seller.buyLotto(money);
        viewer.printLottos(lottos);

        var winningLotto = inputProcessor.inputWinningLotto();

        var result = resultChecker.checkResult(lottos, winningLotto);
        var rateOfReturn = (double) result.getAllReward() / money;
        viewer.printResult(result, rateOfReturn);
    }
}
