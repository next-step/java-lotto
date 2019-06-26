package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoLauncher {

  public static void start() {
    int purchaseAmount = InputView.askPurchaseAmount();
    int lottoQuantity = new Money(purchaseAmount).getAvailableQuantity();
    Quantity quantity = new Quantity(lottoQuantity);
    OutputView.printPurchasedLottoQuantity(quantity);

    Lottos purchasedLottos = Store.buyLottos(quantity);
    OutputView.printPurchasedLottosNumber(purchasedLottos);

    String lastWeekWinLottoNumber = InputView.askLastWeekWinLottoNumber();
    int bonusBallNumber = InputView.askBonusBallNumber();
    LastWeekWinLotto LastWinLotto = new LastWeekWinLotto(lastWeekWinLottoNumber, bonusBallNumber);
    Statistics statistics = new Statistics(purchasedLottos, LastWinLotto);
    OutputView.printStatistics(statistics);
  }

  public static void main(String[] args) {
    LottoLauncher.start();
  }

}
