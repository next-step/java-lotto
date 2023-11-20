package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoResultCalculator;
import lotto.domain.Lottos;
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

        // TODO: 수익률 계산
        Map<String, Integer> results = lottoResultCalculator.calculateResults(lottos, winningLotto);
        double profit = lottoResultCalculator.calculateProfit(results, lottoCount);
        outputView.printResults(results, profit);

    }
}
