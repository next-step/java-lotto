package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoGame {

  private final InputView inputView;

  public LottoGame(Scanner scanner) {
    this.inputView = new InputView(scanner);
  }

  public void play() {
    PurchaseAmount purchaseAmount = receiveMoney();
    Lottos lottos = buyLottos(purchaseAmount);
    Lotto winningLotto = receiveWinningLotto();
    LottoNumber bonusNumber = receiveBonusNumber();
    printResult(purchaseAmount, winningLotto, lottos, bonusNumber);
  }

  private PurchaseAmount receiveMoney() {
    return inputView.receiveMoney();
  }

  private Lottos buyLottos(PurchaseAmount purchaseAmount) {
    LottoShop lottoShop = new LottoShop(new RandomLottoGenerator());
    Lottos lottos = lottoShop.buyLottos(purchaseAmount);
    ResultView.printLottoCount(lottos);
    ResultView.printLottos(lottos);
    return lottos;
  }

  private Lotto receiveWinningLotto() {
    String winninLottoNumbers = inputView.receiveWinningLotto();
    return new Lotto(winninLottoNumbers);
  }

  private LottoNumber receiveBonusNumber() {
    return inputView.receiveBonusNumber();
  }

  private void printResult(PurchaseAmount purchaseAmount, Lotto winningLotto, Lottos lottos, LottoNumber bonusNumber) {
    LottoReport lottoReport = new LottoReport(purchaseAmount, winningLotto, lottos, bonusNumber);
    ResultView.printStatistics(lottoReport);
  }
}
