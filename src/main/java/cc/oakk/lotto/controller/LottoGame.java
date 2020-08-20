package cc.oakk.lotto.controller;

import cc.oakk.lotto.model.*;
import cc.oakk.lotto.view.InputView;
import cc.oakk.lotto.view.ResultView;

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
        resultView.printMoneyInputHeader();
        int lottoCount = inputView.readMoney() / Lotto.PRICE;
        if (lottoCount <= 0) {
            return;
        }
        resultView.repeatPurchasedLottoCount(lottoCount);

        Lottos lottos = generateLottos(lottoCount);
        resultView.printLottos(lottos);
        resultView.printWinningNumberInputHeader();
        Lotto winningLotto = new Lotto(inputView.readWinningNumbers());
        LottoResults results = lottos.getResults(winningLotto);

        resultView.printResultHeader();
        resultView.printLottoResults(results);
    }

    public Lottos generateLottos(int count) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            lottos.add(generator.generate());
        }
        return lottos;
    }
}
