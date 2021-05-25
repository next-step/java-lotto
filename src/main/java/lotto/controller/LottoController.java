package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLotto;
import lotto.generator.LottoNumberGenerator;
import lotto.generator.NumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final NumberGenerator numberGenerator;
    private final LottoStatistics lottoStatistics;

    public LottoController() {
        this.numberGenerator = new LottoNumberGenerator();
        this.lottoStatistics = new LottoStatistics();
    }

    public void play() {
        LottoGame lottoGame = LottoGame.init(InputView.inputAmount());
        int countOfManualLotto = InputView.inputCountOfManualLotto();
        lottoGame.buyLotto(numberGenerator, InputView.inputManualLottoes(countOfManualLotto));

        ResultView.printPurchaseCountAndLottoes(lottoGame, countOfManualLotto);

        Lotto enteredWinningLotto = Lotto.from(InputView.inputWinningLottoNumbers());
        LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusNumber());
        WinningLotto winningLotto = WinningLotto.of(enteredWinningLotto, bonusNumber);

        lottoStatistics.init(lottoGame, winningLotto);
        ResultView.printStatistics(lottoStatistics);
    }
}
