package lotto;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

  public static void main(String[] args) {
    Money money = new Money(InputView.inputMoney());
    Lottos lottos = buyLottos(money);
    ResultView.printLottos(lottos);

    List<Integer> winnerNumber = InputView.inputWinnerNumber();
    checkResult(lottos, winnerNumber);
    ResultView.printResult(lottos);
    ResultView.printIncomePercent(lottos.calculateIncomePercent());
  }

  private static void checkResult(Lottos lottos, List<Integer> winnerNumber) {
    lottos.assignWinNumber(winnerNumber);
    lottos.checkResult();
  }

  private static Lottos buyLottos(Money money) {
    int count = money.getBuyableCount();
    LottoMachine lottoMachine = new LottoMachine();
    Lottos lottos = lottoMachine.generateAuto(count);
    return lottos;
  }


}
