import lotto.Lottos;
import view.InputView;
import view.OutputView;

public class main {

  public static void main(String[] args) {
    OutputView.purchasePrice();
    Lottos lottos = new Lottos();

    OutputView.lottos(lottos.buy(InputView.getIntValue()));

    OutputView.lastWeekWinningNumber();

    }
  }
