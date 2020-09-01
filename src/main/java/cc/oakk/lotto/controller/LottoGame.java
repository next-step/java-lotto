package cc.oakk.lotto.controller;

import cc.oakk.lotto.model.*;
import cc.oakk.lotto.view.InputView;
import cc.oakk.lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    private final LottoGenerator generator;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(LottoGenerator generator, InputView inputView, ResultView resultView) {
        this.generator = generator;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        inputView.printMoneyInputHeader();
        int money = inputView.readMoney();
        Lottos lottos = generator.generateLottos(money);
        if (lottos.size() < 0) {
            return;
        }
        resultView.repeatPurchasedLottoCount(lottos.size());
        resultView.printLottos(lottos);

        inputView.printWinningNumberInputHeader();
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        inputView.printBonusNumberInputHeader();
        int bonusNumber = inputView.readBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResults results = lottos.getResults(winningLotto);

        resultView.printResultHeader();
        resultView.printLottoResults(results);
    }
}
