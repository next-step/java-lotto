package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoGame {

  private final InputView inputView;

  public LottoGame(Scanner scanner) {
    this.inputView = new InputView(scanner);
  }

  public void play() {
    PurchaseAmount purchaseAmount = receiveMoney();
    Lottos lottos = buyLottos(purchaseAmount);
    List<LottoNumber> winningLottoNumbers = receiveWinningLottoNumbers();
    LottoNumber bonusNumber = receiveBonusNumber();
    WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
    printResult(purchaseAmount, winningLotto, lottos);
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

  private List<LottoNumber> receiveWinningLottoNumbers() {
    return inputView.receiveWinningLottoNumbers();
  }

  private LottoNumber receiveBonusNumber() {
    return inputView.receiveBonusNumber();
  }

  private void printResult(PurchaseAmount purchaseAmount, WinningLotto winningLotto, Lottos lottos) {
    LottoReport lottoReport = new LottoReport(purchaseAmount, winningLotto, lottos);
    ResultView.printStatistics(lottoReport);
  }
}
