package lotto.view;

import java.util.List;
import lotto.domain.Money;
import lotto.domain.Number;

public class TestConsoleInputView extends ConsoleInputView {

  private Money money;
  private List<Number> winNumbers;

  public TestConsoleInputView(Money money, List<Number> winNumbers) {
    this.money = money;
    this.winNumbers = winNumbers;
  }

  @Override
  public Money inputPurchaseAmount() {
    return money;
  }

  @Override
  public List<Number> inputWinNumbers() {
    return winNumbers;
  }
}
