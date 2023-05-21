package study.lotto.controller;

import study.lotto.model.Lotto;
import study.lotto.model.LottoNumber;
import study.lotto.model.LottoStatistics;
import study.lotto.service.LottoService;
import study.lotto.view.InputView;
import study.lotto.view.OutputView;

public class LottoController {

  private final InputView inputView;
  private final OutputView outputView;
  private final LottoService lottoService;

  public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.lottoService = lottoService;
  }

  public void run() {
    int amount = inputView.getAmount();
    Lotto lotto = lottoService.makePurchase(amount);
    outputView.purchaseView(lotto);
    LottoNumber winningNumber = inputView.previousWinningNumbers();
    LottoStatistics lottoStatistics = new LottoStatistics(lotto, winningNumber);
    outputView.winningStatistics(lottoStatistics);
  }

}
