package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.domain.WinNumbers;
import lotto.domain.WinStats;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    int insertMoney = consoleInputView.inputPurchaseAmount();
    MyLottos myLottos = buyLottos(insertMoney);

    String inputWinNumbers = consoleInputView.inputWinNumbers();
    int inputAdditionNumber = consoleInputView.inputAdditionNumber();
    WinNumbers winNumbers = WinNumbers.of(inputWinNumbers, inputAdditionNumber);

    winState(myLottos, winNumbers);
  }

  private static List<String> inputManualLotto(int buyQuantity) {

    int manualQuantity = consoleInputView.inputManualQuantity();
    if (manualQuantity > buyQuantity) {
      throw new IllegalArgumentException();
    }

    List<String> inputLottoNumbers = new ArrayList<>();
    if (manualQuantity > 0) {
      inputLottoNumbers = consoleInputView.inputManualNumbers(manualQuantity);
    }

    return inputLottoNumbers;
  }

  private static void winState(MyLottos myLottos, WinNumbers winNumber) {

    ConsoleResultView.printResultTitle();

    WinStats winStats = myLottos.winStats(winNumber);
    ConsoleResultView.printMatchWinCount(winStats);

    String yield = winStats.yield();
    ConsoleResultView.printYield(yield);
  }

  private static MyLottos buyLottos(int insertMoney) {

    Money buyMoney = new Money(insertMoney);
    int buyQuantity = LottoStore.quantity(buyMoney);

    List<String> inputLottoNumbers = inputManualLotto(buyQuantity);
    Lottos lottos = LottoStore.buy(buyQuantity, inputLottoNumbers);
    for (Lotto lotto : lottos.getLottos()) {
      ConsoleResultView.printIssueLottoNumbers(lotto);
    }

    return new MyLottos(buyMoney, lottos);
  }
}
