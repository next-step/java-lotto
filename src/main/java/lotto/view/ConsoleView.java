package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.domain.WinNumbers;
import lotto.domain.WinStats;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    int insertMoney = consoleInputView.inputPurchaseAmount();
    MyLottos myLottos = buyLottos(insertMoney);

    String winNumberString = consoleInputView.inputWinNumbers();
    WinNumbers winNumbers = winNumbers(winNumberString);

    winState(myLottos, winNumbers);
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
    List<Lotto> lottos = LottoStore.buy(buyMoney);
    for (Lotto lotto : lottos) {
      ConsoleResultView.printIssueLottoNumbers(lotto);
    }

    return new MyLottos(buyMoney, lottos);

  }

  private static WinNumbers winNumbers(String winNumberString) {

    String[] winNumberArray = winNumberString.split(",");
    Set<LottoNumber> winNumbers = Arrays.stream(winNumberArray)
        .map(winNumber -> new LottoNumber(Integer.parseInt(winNumber.trim())))
        .collect(Collectors.toSet());

    return new WinNumbers(winNumbers);
  }
}
