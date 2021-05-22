package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoStatistics;
import lotto.generator.LottoNumberGenerator;
import lotto.generator.NumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final NumberGenerator numberGenerator;
    private final LottoStatistics lottoStatistics;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.numberGenerator = new LottoNumberGenerator();
        this.lottoStatistics = new LottoStatistics();
    }

    public void play() {
        LottoGame lottoGame = LottoGame.init(inputView.inputAmount());
        lottoGame.buyLotto(numberGenerator);
        resultView.printLottoes(lottoGame);

        Lotto winnerLotto = Lotto.from(inputView.inputWinnerLottoNumbers());
        lottoStatistics.init(lottoGame, winnerLotto);

        resultView.printStatistics(lottoStatistics);
    }
}
