package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoReport;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.PurchaseInfo;
import lotto.domain.WinningLotto;
import lotto.domain.generator.RandomLottoGenerator;
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
    try {
      int customerMoney = receiveMoney();
      int manualLottoCount = receiveManualLottoCount();
      PurchaseInfo purchaseInfo = new PurchaseInfo(customerMoney, manualLottoCount);
      Lottos lottos = buyLottos(purchaseInfo);
      List<LottoNumber> winningLottoNumbers = receiveWinningLottoNumbers();
      LottoNumber bonusNumber = receiveBonusNumber();
      WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
      printResult(purchaseInfo, winningLotto, lottos);
    } catch (IllegalArgumentException e) {
      System.out.println("에러 발생: " + e.getMessage());
    }
  }

  private int receiveMoney() {
    return inputView.receiveMoney();
  }

  private int receiveManualLottoCount() {
    return inputView.receiveManualLottoCount();
  }

  private Lottos buyLottos(PurchaseInfo purchaseInfo) {
    LottoShop lottoShop = new LottoShop(new RandomLottoGenerator(), inputView);
    Lottos lottos =  lottoShop.buyLottos(purchaseInfo);
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

  private void printResult(PurchaseInfo purchaseInfo, WinningLotto winningLotto, Lottos lottos) {
    LottoReport lottoReport = new LottoReport(purchaseInfo, winningLotto, lottos);
    ResultView.printStatistics(lottoReport);
  }
}
