package lotto;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

  public static final LottoMachine lottoMachine = new LottoMachine();

  public static void main(String[] args) {
    Money money = new Money(InputView.inputMoney());
    int buyableLottoCount = money.getBuyableCount();
    int manualTicketCount = InputView.inputManualTicketCount();
    int autoTicketCount = buyableLottoCount - manualTicketCount;

    Lottos lottos = buyManual(manualTicketCount);
    lottos.addAll(lottoMachine.buyAuto(autoTicketCount));
    ResultView.printLottosCount(manualTicketCount, autoTicketCount);
    ResultView.printLottos(lottos);

    List<Integer> winnerNumber = InputView.inputWinnerNumber();
    int bonusNumber = InputView.inputBonusNumber();
    lottos.checkResult(winnerNumber, bonusNumber);
    ResultView.printResult(lottos);
    ResultView.printIncomePercent(lottos.calculateIncomePercent());
  }

  private static Lottos buyManual(int manualTicketCount) {
    InputView.printInputManualLotto();
    Lottos lottos = new Lottos();
    for (int i = 0; i < manualTicketCount; i++) {
      List<Integer> numbers = InputView.inputManualLottoNumbers();
      lottos.add(lottoMachine.generateManual(numbers));
    }
    return lottos;
  }


}
