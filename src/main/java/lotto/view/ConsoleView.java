package lotto.view;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    /*
    int insertMoney = consoleInputView.inputPurchaseAmount();
    MyLottos myLottos = generateLotto(insertMoney);

    String winNumberString = consoleInputView.inputWinNumbers();
    Set<Integer> winNumber = winNumbers(winNumberString);

    winState(myLottos, winNumber);
    */
  }

  /*
  private static void winState(MyLottos myLottos, Set<Integer> winNumber) {

    ConsoleResultView.printResultTitle();

    WinStats winStats = new WinStats(myLottos, winNumber);
    ConsoleResultView.printMatchWinCount(winStats.getWinCounts());

    String yield = winStats.yield();
    ConsoleResultView.printYield(yield);

  }
  */

  /*
  private static MyLottos generateLotto(int insertMoney) {

    Money purchaseMoney = new Money(insertMoney);
    MyLottos myLottos = new LottoVendingMachine().purchaseLotto(purchaseMoney);
    for (Lotto lotto : myLottos.getLottos()) {
      ConsoleResultView.printIssueLottoNumbers(lotto.getNumbers());
    }

    return myLottos;

  }
  */

  /*
  private static Set<Integer> winNumbers(String winNumberString) {

    String[] winNumberArray = winNumberString.split(",");
    return Arrays.stream(winNumberArray)
        .map(winNumber -> Integer.parseInt(winNumber.trim()))
        .collect(Collectors.toSet());
  }
  */
}
