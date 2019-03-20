package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoVendingMachine;
import lotto.domain.Money;
import lotto.domain.Number;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  private static final LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();

  public static void main(String[] args) {

    int insertMoney = consoleInputView.inputPurchaseAmount();
    List<Lotto> purchaseLottoList = issueLotto(insertMoney);

    String winNumberString = consoleInputView.inputWinNumbers();
    List<Number> winNumber = winNumbers(winNumberString);

    ConsoleResultView.printResultTitle();

    Money winMoney = lottoVendingMachine.totalWinMoney(purchaseLottoList, winNumber);
    lottoVendingMachine.yield(new Money(insertMoney), winMoney);
  }

  public static List<Lotto> issueLotto(int insertMoney) {

    Money purchaseMoney = new Money(insertMoney);
    List<Lotto> purchaseLottoList = lottoVendingMachine.purchaseLotto(purchaseMoney);
    for (Lotto lotto : purchaseLottoList) {
      ConsoleResultView.printIssueLottoNumbers(lotto.getNumbers());
    }

    return purchaseLottoList;
  }

  public static List<Number> winNumbers(String winNumberString) {

    String[] winNumberArray = winNumberString.split(", ");
    return Arrays.stream(winNumberArray)
        .map(Number::new)
        .collect(Collectors.toList());
  }
}
