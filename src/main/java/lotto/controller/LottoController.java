package lotto.controller;

import java.util.List;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.LottoRankStatistics;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.lottoMachine = new LottoMachine(new LottoNumbersGenerator());
    }

    public void playLotto() {
        Price price = new Price(this.inputView.getBuyPrice());
        List<LottoNumbers> manualLottoNumbers = this.inputView.getManualLottoNumbers(price);
        Lottos lottos = this.lottoMachine.createLottos(price, manualLottoNumbers);
        this.resultView.printBuyLottosCount(lottos.getSize(), manualLottoNumbers.size());
        this.resultView.printLottoNumbers(lottos);
        winningConfirmation(lottos);
    }

    private void winningConfirmation(Lottos lottos) {
        WinningNumbers winningNumbers = new WinningNumbers(this.inputView.getWinningNumber(),
                this.inputView.getBonusNumber());
        LottoRankStatistics lottoStatistics = new LottoRankStatistics(lottos, winningNumbers);
        this.resultView.printStatisticsResult(lottoStatistics);
        this.resultView.printRateOfReturnResult(lottoStatistics);
    }
}
