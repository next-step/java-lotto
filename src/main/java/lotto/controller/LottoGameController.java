package lotto.controller;

import lotto.domain.*;
import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;
import java.util.List;

public class LottoGameController {

  private final InputView inputView;
  private final ResultView resultView;

  public LottoGameController() {
    inputView = new InputView();
    resultView = new ResultView();
  }

  public void runGame() {
    int purchasePrice = drawPurchasePrice();
    Money money = new Money(purchasePrice);
    int lottoCount = money.calculateLottoCount();
    drawLottoCount(lottoCount);

    LottoMachine lottoMachine = new LottoMachine(money, new AutoLottoGenerator());
    drawLottoList(lottoMachine);

    LastWinningLotto lastWeekWinningLotto = LastWinningLotto.of(drawWinningLotto(),drawBonusBall());

    LottoStaticResult lottoStaticResult
        = lottoMachine.makeMatchingCount(lastWeekWinningLotto);
    drawLottoStatics(lottoStaticResult);

    double yield = lottoStaticResult.calculate(purchasePrice);
    drawLottoEarningRate(yield, lottoStaticResult.isBenefit(yield));
  }

  private int drawBonusBall() {
    return inputView.inputBonusBall();
  }

  private void drawLottoEarningRate(double earningRate, boolean isBenefit) {
    resultView.printLottoEarningRate(earningRate, isBenefit);
  }

  private List<Integer> drawWinningLotto() {
    return inputView.inputWinningLottoNumbers();
  }

  private void drawLottoStatics(LottoStaticResult lottoStaticResult) {
    resultView.printLottoStatics(lottoStaticResult);
  }

  private void drawLottoList(LottoMachine lottoList) {
    resultView.printLottoList(lottoList);
  }

  private void drawLottoCount(int lottoCount) {
    resultView.printLottoCount(lottoCount);
  }

  private int drawPurchasePrice() {
    return inputView.inputPurchasePrice();
  }
}
