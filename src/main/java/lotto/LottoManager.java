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
      InputView inputView = new InputView(scanner);
      start(inputView);
    }
  }

  private static void start(InputView inputView) {
    Money userMoney = inputView.inputMoney();
    LottoCount lottoCount = new LottoCount(userMoney);
    Printer.printBlankLine();

    LottoCount manualCount = inputView.inputManualCount();
    LottoCounts lottoCounts = new LottoCounts(lottoCount, manualCount);
    Printer.printBlankLine();

    Lottos userLottos = new Lottos(lottoCount);
    userLottos.addLottoList(inputView.inputManualLottoNumber(manualCount));
    userLottos.addLottoList(lottoCounts.automaticLottos());
    Printer.printBlankLine();

    Printer.printLottoCount(userLottos, manualCount);
    Printer.printLottos(userLottos);

    WinningLotto winningLotto = inputView.inputWinningLotto();
    WinningStatistics winningStatistics = new WinningStatistics(userLottos, winningLotto);
    Printer.printRank(winningStatistics);
    Printer.printResult(winningStatistics, userMoney);
  }
}
