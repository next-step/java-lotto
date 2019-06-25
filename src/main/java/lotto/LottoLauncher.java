package lotto;

import java.util.Scanner;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoLauncher {

  public static void start() {
    Scanner scanner = new Scanner(System.in);

    InputView.askPurchaseAmount();
    int purchaseAmount = scanner.nextInt();
    int lottoQuantity = new Money(purchaseAmount).getAvailableQuantity();
    Quantity quantity = new Quantity(lottoQuantity);
    OutputView.printPurchasedLottoQuantity(quantity);

    Lottos purchasedLottos = Store.buyLottos(quantity);
    OutputView.printPurchasedLottosNumber(purchasedLottos);

    InputView.askLastWeekWinLottoNumber();
    String lastWeekWinLottoNumber = scanner.next();

    OutputView.printStatistics(purchasedLottos, lastWeekWinLottoNumber);
  }

  public static void main(String[] args) {
    LottoLauncher.start();
  }

}
