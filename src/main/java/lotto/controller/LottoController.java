package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.LottoRankStatistics;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.utils.LottoNumbersUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private Lottos lottos;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void playLotto() {
        Price price = new Price(this.inputView.getBuyPrice());
        LottoMachine lottoMachine = new LottoMachine(price, new LottoNumbersGenerator());
        this.lottos = lottoMachine.createLottos();
    }

    public void showResult() {
        this.resultView.printLottosNumber(this.lottos);
        LottoNumbers winningLottoNumbers = LottoNumbersUtil.toLottoNumbers(this.inputView.getWinningNumber());
        LottoRankStatistics lottoStatistics = new LottoRankStatistics(this.lottos, winningLottoNumbers);
        lottoStatistics.initStatistics();
        this.resultView.printStatisticsResult(lottoStatistics);
        this.resultView.printRateOfReturnResult(lottoStatistics);
    }
}
