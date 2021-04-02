package lotto;

import java.util.Scanner;
import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoCounts;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.io.InputView;
import lotto.io.Printer;

public final class LottoManager {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      start(scanner);
    }
  }

  private static void start(Scanner scanner) {
    InputView inputView = new InputView(scanner);

    Money userMoney = inputView.inputMoney();
    LottoCount lottoCount = new LottoCount(userMoney.divideBy(Lottos.PRICE).toInteger());
    System.out.println();

    LottoCount manualCount = new LottoCount(inputView.inputManualCount());
    LottoCounts lottoCounts = new LottoCounts(lottoCount, manualCount);
    System.out.println();

    Lottos userLottos = new Lottos(lottoCount);
    userLottos.addLottoList(inputView.inputManualLottoNumber(manualCount));
    userLottos.addLottoList(lottoCounts.automaticLottos());
    System.out.println();

    Printer.printLottoCount(userLottos, manualCount);
    Printer.printLottos(userLottos);

    WinningLotto winningLotto = inputView.inputLastWinningNumber();
    WinningStatistics winningStatistics = new WinningStatistics(userLottos, winningLotto);
    Printer.printRank(winningStatistics);
    Printer.printResult(winningStatistics, userMoney);
  }
}
