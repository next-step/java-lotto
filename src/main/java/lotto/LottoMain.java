package lotto;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

  public static final LottoMachine LOTTO_MACHINE = new LottoMachine();

  public static void main(String[] args) {
    Money money = new Money(InputView.inputMoney());
    Lottos lottos = buyLottos(money);
    ResultView.printLottos(lottos);

    List<Integer> winnerNumber = InputView.inputWinnerNumber();
    int bonusNumber = InputView.inputBonusNumber();
    lottos.checkResult(winnerNumber, bonusNumber);
    ResultView.printResult(lottos);
    ResultView.printIncomePercent(lottos.calculateIncomePercent());
  }

  private static Lottos buyLottos(Money money) {
    int count = money.getBuyableCount();
    return LOTTO_MACHINE.generateAuto(count);
  }


}
