package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

  public static final String DELIMITER = ", ";

  public static void main(String[] args) {
    Money money = new Money(InputView.inputMoney());
    int count = money.buyLotto();
    Lottos lottos = LottoMachine.generateAuto(count);
    lottos.print();
    List<Integer> winnerNumber = getWinnerNumbers();
    lottos.assignWinNumber(winnerNumber);
    lottos.checkResult();
    ResultView.printResult(lottos);
    ResultView.printIncomePercent(lottos.calculateIncomePercent());
  }

  private static List<Integer> getWinnerNumbers() {
    String winnerNumberString = InputView.inputWinnerNumber();
    String[] split = winnerNumberString.split(DELIMITER);
    List<Integer> winnerNumber = new ArrayList<>();
    for (String string : split) {
      int number = Integer.parseInt(string);
      winnerNumber.add(number);
    }
    return winnerNumber;
  }

}
