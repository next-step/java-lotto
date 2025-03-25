package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoGame {

  private final Scanner scanner;

  public LottoGame(Scanner scanner) {
    this.scanner = scanner;
  }

  public void play() {
    int money = receiveMoney();
    Lottos lottos = buyLottos(money);
    Lotto winningLotto = receiveWinningLotto();
    printResult(winningLotto, lottos);
  }

  private int receiveMoney() {
    InputView inputView = new InputView(scanner);
    return inputView.receiveMoney();
  }

  private Lottos buyLottos(int money) {
    LottoShop lottoShop = new LottoShop(new RandomLottoGenerator());
    Lottos lottos = lottoShop.buyLottos(money);
    ResultView.printLottoCount(lottos);
    ResultView.printLottos(lottos);
    return lottos;
  }

  private Lotto receiveWinningLotto() {
    InputView inputView = new InputView(scanner);
    String winninLottoNumbers = inputView.receiveWinningLotto();
    return new Lotto(winninLottoNumbers);
  }

  private void printResult(Lotto winningLotto, Lottos lottos) {
    LottoReport lottoReport = new LottoReport(winningLotto, lottos);
    ResultView.printStatistics(lottoReport);
  }
}
