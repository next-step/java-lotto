package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoResultCalculator lottoResultCalculator;

    public LottoController(InputView inputView, OutputView outputView, LottoResultCalculator lottoResultCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoResultCalculator = lottoResultCalculator;
    }

    public void startGame() {
        outputView.askLottoAmount();
        LottoAmount lottoAmount = inputView.inputLottoAmount();

        int lottoCount = lottoAmount.findLottoCount();
        outputView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        outputView.printLottos(lottos);

        outputView.askWinningLotto();
        Lotto winningLotto = inputView.inputWinningLotto();

        outputView.askBonusLotto();
        LottoNumber bonusNumber = inputView.inputBonusLotto();

        Map<String, Integer> results = lottoResultCalculator.calculateResults(lottos, winningLotto, bonusNumber);
        double profit = lottoResultCalculator.calculateProfit(results, lottoCount);
        outputView.printResults(results, profit);
    }
}
