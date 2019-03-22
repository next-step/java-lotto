package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoVendingMachine;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.domain.WinStats;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    int insertMoney = consoleInputView.inputPurchaseAmount();
    MyLottos myLottos = generateLotto(insertMoney);

    String winNumberString = consoleInputView.inputWinNumbers();
    List<Integer> winNumber = winNumbers(winNumberString);

    winState(myLottos, winNumber);
  }

  private static void winState(MyLottos myLottos, List<Integer> winNumber) {

    ConsoleResultView.printResultTitle();

    WinStats winStats = new WinStats(myLottos.getLottos(), winNumber);
    winStats.total();
    ConsoleResultView.printMatchWinCount(winStats.getWinCounts());

    String yield = winStats.yield(myLottos.getBuyMoney());
    ConsoleResultView.printYield(yield);
  }

  private static MyLottos generateLotto(int insertMoney) {

    Money purchaseMoney = new Money(insertMoney);
    MyLottos myLottos = new LottoVendingMachine().purchaseLotto(purchaseMoney);
    for (Lotto lotto : myLottos.getLottos()) {
      ConsoleResultView.printIssueLottoNumbers(lotto.getNumbers());
    }

    return myLottos;
  }

  private static List<Integer> winNumbers(String winNumberString) {

    String[] winNumberArray = winNumberString.split(",");
    return Arrays.stream(winNumberArray)
        .map(winNumber -> Integer.parseInt(winNumber.trim()))
        .collect(Collectors.toList());
  }
}
