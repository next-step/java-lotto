package lotto;

import java.util.Scanner;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.io.InputView;
import lotto.io.Printer;

public final class LottoManager {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      InputView inputView = new InputView(scanner);
      int money = inputView.inputMoney();
      System.out.println();
      int manualCount = inputView.inputManualCount();
      System.out.println();

      Money userMoney = new Money(money);
      Lottos userLottos = new Lottos(userMoney);
      Printer.printLottoCount(userLottos, manualCount);
      Printer.printLottos(userLottos);

      WinningLotto winningLotto = inputView.inputLastWinningNumber();
      WinningStatistics winningStatistics = new WinningStatistics(userLottos, winningLotto);
      Printer.printRank(winningStatistics);
      Printer.printResult(winningStatistics, userMoney);
    }
  }
}
