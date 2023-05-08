import lotto.Lottos;
import lotto.WinningNumbers;
import view.InputView;
import view.OutputView;

public class main {

  public static void main(String[] args) {
    OutputView.purchasePrice();
    Lottos lottos = new Lottos();

    OutputView.lottos(lottos.buy(InputView.getIntValue()));

    OutputView.lastWeekWinningNumber();
    InputView.getStringValue(); // Scanner에 enter가 남아있어 enter를 먹어 없애기 위한 코드
    OutputView.statistics(lottos.findWinner(new WinningNumbers(InputView.getStringValue())));
  }
}
