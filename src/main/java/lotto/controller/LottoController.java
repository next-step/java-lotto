package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private InputView inputView;
    private ResultView resultView;
    private LottoNumbersGenerator generator;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.generator = new LottoNumbersGenerator();
    }

    public void playLotto() {
        Price price = new Price(this.inputView.getBuyPrice());
        LottoMachine lottoMachine = new LottoMachine(price);
        Lottos lottos = lottoMachine.getLottos();
        this.resultView.printLottosNumber(lottos);
        LottoNumbers winningLottoNumbers = this.generator.toLottoNumbers(this.inputView.getWinningNumber());
        LottoStatistics lottoStatistics = lottos.getLottoStatisticsByWinningNumbers(winningLottoNumbers);
        this.resultView.printStatisticsResult(lottoStatistics);
        Double rateOfReturn = lottoStatistics.calculateRateOfReturnByPrice(price);
        this.resultView.printRateOfReturnResult(rateOfReturn);
    }
}
