package lotto.controller;

import java.util.ArrayList;
import lotto.domain.*;
import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.ManualLottoGenerator;
import lotto.domain.generator.MergedGenerator;
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

    int count = drawManualLottoCount();
    List<List<Integer>> manualLottos = drawManualLotto(count);

    List<LottoGenerator> generators = new ArrayList<>();
    generators.add(new ManualLottoGenerator(manualLottos));
    money.decreaseByManualLottoCount(manualLottos.size());
    generators.add(new AutoLottoGenerator(money.calculateLottoCount()));

    LottoGenerator lottoGenerator = new MergedGenerator(generators);

    LottoMachine lottoMachine
        = new LottoMachine(lottoGenerator);

    drawLottoCount(count, money.calculateLottoCount());
    drawLottoList(lottoMachine);

    LastWinningLotto lastWeekWinningLotto = LastWinningLotto.of(drawWinningLotto(), drawBonusBall());

    LottoStaticResult lottoStaticResult
        = lottoMachine.makeMatchingCount(lastWeekWinningLotto);
    drawLottoStatics(lottoStaticResult);

    double yield = lottoStaticResult.calculate(purchasePrice);
    drawLottoEarningRate(yield, lottoStaticResult.isBenefit(yield));
  }

  private List<List<Integer>> drawManualLotto(int count) {
    return inputView.inputLottoNumbers(count);
  }

  private int drawManualLottoCount() {
    return inputView.inputManualLottoCount();
  }

  private int drawBonusBall() {
    return inputView.inputBonusBall();
  }

  private void drawLottoEarningRate(double earningRate, boolean isBenefit) {
    resultView.printLottoEarningRate(earningRate, isBenefit);
  }

  private List<Integer> drawWinningLotto() {
    return inputView.inputLottoNumbers();
  }

  private void drawLottoStatics(LottoStaticResult lottoStaticResult) {
    resultView.printLottoStatics(lottoStaticResult);
  }

  private void drawLottoList(LottoMachine lottoList) {
    resultView.printLottoList(lottoList);
  }

  private void drawLottoCount(int manualCount, int autoCount) {
    resultView.printLottoCount(manualCount, autoCount);
  }

  private int drawPurchasePrice() {
    return inputView.inputPurchasePrice();
  }
}
