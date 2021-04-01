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

      Money userMoney = new Money(inputView.inputMoney());
      long lottoCount = userMoney.divideBy(Lottos.PRICE).toInteger();
      System.out.println();

      int manualCount = inputView.inputManualCount();
      validateManualCount(lottoCount, manualCount);
      System.out.println();

      Lottos userLottos = new Lottos(lottoCount);
      Printer.printLottoCount(userLottos, manualCount);
      Printer.printLottos(userLottos);

      WinningLotto winningLotto = inputView.inputLastWinningNumber();
      WinningStatistics winningStatistics = new WinningStatistics(userLottos, winningLotto);
      Printer.printRank(winningStatistics);
      Printer.printResult(winningStatistics, userMoney);
    }
  }

  private static void validateManualCount(long lottoCount, int manualCount) {
    if (manualCount < 0) {
      throw new IllegalArgumentException("수동 구매의 장 수는 음수일 수 없습니다.");
    }
    if (manualCount > lottoCount) {
      throw new IllegalArgumentException("구매한 매수보다 수동으로 더 많이 구매할 수 없습니다.");
    }
  }
}
