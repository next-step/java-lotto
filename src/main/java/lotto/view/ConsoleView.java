package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoVendingMachine;
import lotto.domain.Money;
import lotto.domain.WinStats;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    int insertMoney = consoleInputView.inputPurchaseAmount();
    List<Lotto> purchaseLottoList = generateLotto(insertMoney);

    String winNumberString = consoleInputView.inputWinNumbers();
    List<Integer> winNumber = winNumbers(winNumberString);

    winState(insertMoney, purchaseLottoList, winNumber);
  }

  private static void winState(
      int insertMoney,
      List<Lotto> purchaseLottoList,
      List<Integer> winNumber) {
    ConsoleResultView.printResultTitle();

    WinStats winStats = new WinStats(purchaseLottoList, winNumber);
    winStats.total();

    ConsoleResultView.printMatchWinCount(winStats.getWinCounts());

    String yield = winStats.yield(new Money(insertMoney));
    ConsoleResultView.printYield(yield);
  }

  private static List<Lotto> generateLotto(int insertMoney) {

    Money purchaseMoney = new Money(insertMoney);
    List<Lotto> purchaseLottoList = new LottoVendingMachine().purchaseLotto(purchaseMoney);
    for (Lotto lotto : purchaseLottoList) {
      ConsoleResultView.printIssueLottoNumbers(lotto.getNumbers());
    }

    return purchaseLottoList;
  }

  private static List<Integer> winNumbers(String winNumberString) {

    String[] winNumberArray = winNumberString.split(",");
    return Arrays.stream(winNumberArray)
        .map(winNumber -> Integer.parseInt(winNumber.trim()))
        .collect(Collectors.toList());
  }
}
