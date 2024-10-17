package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Price;
import lotto.model.Statistics;
import lotto.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

public class LottoGame {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Price price = inputView.readPrice();

        Lottos lottos = lottoService.generateLottos(price);

        outputView.printLotto(lottos);

        Lotto winningLotto = inputView.readWinningLotto();

        Statistics statistics = lottoService.generateStatistics(lottos, winningLotto, price);

        outputView.printStatistics(statistics);
    }
}
