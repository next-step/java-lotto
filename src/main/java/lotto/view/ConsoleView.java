package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.domain.WinNumbers;
import lotto.domain.WinStats;
import lotto.domain.WinningNumbers;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    int insertMoney = consoleInputView.inputPurchaseAmount();
    MyLottos myLottos = buyLottos(insertMoney);

    String inputWinNumbers = consoleInputView.inputWinNumbers();
    int inputAdditionNumber = consoleInputView.inputAdditionNumber();
    WinNumbers winNumbers = winNumbers(inputWinNumbers, inputAdditionNumber);

    winState(myLottos, winNumbers);
  }

  private static List<Lotto> manualLotto(int buyQuantity) {

    int manualQuantity = consoleInputView.inputManualQuantity();
    if (manualQuantity > buyQuantity) {
      throw new IllegalArgumentException();
    }

    List<String> inputLottoNumbers = new ArrayList<>();
    if (manualQuantity > 0) {
      consoleInputView.inputManualNumbers(manualQuantity);
    }
    return inputLottoNumbers.stream()
        .map(ConsoleView::convertStringToLottoNumbers)
        .map(Lotto::new)
        .collect(Collectors.toList());
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

    List<Lotto> manualLottos = manualLotto(insertMoney);
    int autoQuantity = buyQuantity - manualLottos.size();
    Lottos lottos = LottoStore.buy(autoQuantity, manualLottos);
    for (Lotto lotto : lottos.getLottos()) {
      ConsoleResultView.printIssueLottoNumbers(lotto);
    }

    return new MyLottos(buyMoney, lottos);

  }

  private static WinNumbers winNumbers(String inputWinNumbers, int inputAdditionNumber) {

    WinningNumbers winningNumbers = new WinningNumbers(convertStringToLottoNumbers(inputWinNumbers));
    LottoNumber additionalNumber = LottoNumber.getInstance(inputAdditionNumber);

    return new WinNumbers(winningNumbers, additionalNumber);
  }

  private static Set<LottoNumber> convertStringToLottoNumbers(String inputLottoNumbers) {

    String[] winNumberArray = inputLottoNumbers.split(",");
    return Arrays.stream(winNumberArray)
        .filter(winNumber -> !winNumber.trim().isEmpty())
        .map(winNumber -> LottoNumber.getInstance(Integer.parseInt(winNumber.trim())))
        .collect(Collectors.toSet());
  }
}
