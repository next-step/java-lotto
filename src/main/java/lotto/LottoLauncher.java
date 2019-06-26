package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoLauncher {

  public static void start() {

    Quantity totalQuantity = getTotalQuantity();
    Quantity manualLottoQuantity = getManualQuantity();
    Quantity autoLottoQuantity = totalQuantity.minus(manualLottoQuantity);
    List<String> manualLottoNumbers = getManualLottoNumbers(manualLottoQuantity);

    OutputView.printPurchasedLottoQuantity(manualLottoQuantity, autoLottoQuantity);

    Lottos purchasedLottos = Store.buyLottos(autoLottoQuantity, manualLottoNumbers);
    OutputView.printPurchasedLottosNumber(purchasedLottos);

    String lastWeekWinLottoNumber = InputView.askLastWeekWinLottoNumber();
    int bonusBallNumber = InputView.askBonusBallNumber();
    LastWeekWinLotto LastWinLotto = new LastWeekWinLotto(lastWeekWinLottoNumber, bonusBallNumber);
    Statistics statistics = new Statistics(purchasedLottos, LastWinLotto);
    OutputView.printStatistics(statistics);
  }

  private static Quantity getTotalQuantity() {
    int purchaseAmount = InputView.askPurchaseAmount();
    int lottoQuantity = new Money(purchaseAmount).getAvailableQuantity();
    return new Quantity(lottoQuantity);
  }

  private static Quantity getManualQuantity() {
    int manualLottoCount = InputView.askManualLottoBuyQuantity();
    return new Quantity(manualLottoCount);
  }

  private static List<String> getManualLottoNumbers(Quantity manualLottoQuantity) {
    InputView.askManualLottoNumbers();
    List<String> manualLottoNumbers = new ArrayList<>();
    for (int i = 0; i < manualLottoQuantity.getValue(); i++) {
      manualLottoNumbers.add(InputView.manualLottoNumberInput());
    }
    return manualLottoNumbers;
  }

  public static void main(String[] args) {
    LottoLauncher.start();
  }

}
