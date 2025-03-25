package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    return createWinningLotto(winninLottoNumbers);
  }

  private Lotto createWinningLotto(String winninLottoNumbers) {
    List<LottoNumber> numbers = Arrays.stream(winninLottoNumbers.split(","))
            .map(String::trim)
            .map(num -> new LottoNumber(Integer.parseInt(num)))
            .collect(Collectors.toList());
    return new Lotto(numbers);
  }

  private void printResult(Lotto winningLotto, Lottos lottos) {
    LottoReport lottoReport = new LottoReport(winningLotto, lottos);
    ResultView.printStatistics(lottoReport);
  }
}
